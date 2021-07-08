package jianzhiOffer;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class Solution60 {

    public void F(int sum, int n, HashMap<Integer,Integer> dict){
        if (n==0){
            if (!dict.containsKey(sum)) dict.put(sum, 1);
            else    dict.put(sum,dict.get(sum)+1);
            return;
        }
        for(int x=1;x<=6;x++){
            F(sum+x,n-1, dict);
        }
    }

    public double[] dicesProbability(int n) {
        HashMap<Integer,Integer> dict = new HashMap<>();
        F(0,n,dict);
        int sum = 0;
        for (Integer value : dict.values()) sum+=value;

        double[] vals = new double[5*n+1];
        for(Map.Entry<Integer, Integer> entry : dict.entrySet()){
            vals[entry.getKey() - n] = new BigDecimal((double)entry.getValue() / sum).setScale(5,BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return vals;
    }

    public double[] dicesProbability_DP(int n){
        int[][] dp = new int[n][6*n+1];
        for (int j=1;j<=6;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<n;i++){
            for (int j=0;j<6*n+1;j++){
                for(int k=1;k<=6;k++){
                    if (j>=k)  dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        int sum = 0;
        for (int j=0;j<dp[n-1].length;j++){
            sum += dp[n-1][j];
        }
        double[] prob = new double[5*n+1];
        for (int j=n;j<=6*n;j++){
            prob[j-n] = (double) dp[n-1][j] / sum;
        }
        return prob;
    }


    public static void main(String[] args) {
        Solution60 s = new Solution60();
        double[] r = s.dicesProbability_DP(2);
        for (int i=0;i<r.length;i++){
            System.out.println(r[i]);
        }
    }
}
