package common;

import java.util.List;

/**
 * 01背包问题
 * 给定 n 件物品，物品的重量为 w[i]，物品的价值为 c[i]。
 * 现挑选物品放入背包中，假定背包能承受的最大重量为 V，问应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
 */

public class Bag01 {

    public List<Integer> bag(int n, int[] w, int[] c, int V){
        int[][] dp = new int[n+1][V+1];
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                if ()
            }
        }
    }

}
