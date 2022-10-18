package common;

import java.util.List;

/*



dakdhakdhakdhja
 */

/**
 * 01背包问题
 * 给定 n 件物品，物品的重量为 w[i]，物品的价值为 c[i]。
 * 现挑选物品放入背包中，假定背包能承受的最大重量为 V，问应该如何选择装入背包中的物品，使得装入背包中物品的总价值最大？
 */

public class Bag01 {
    /**
     * dp[i][j]表示放第i件物品使得总重量小于j时的最大价值，如果说当前的物品的重量大于j，说明当前物品无论如何都放不下，因此此时的最大价值
     * 就是放上一件物品时的最大价值，即dp[i-1][j]；但是如果当前物品的重量小于j,说明当前物品是放得下的，计算dp[i-1][j-w[i]] + c[i])，
     * 其中j-w[i]表示当前容量刚好能放下当前物品
    */
    public int bag(int n, int[] w, int[] c, int V){
        int[][] dp = new int[n][V+1];

        for (int i=0;i<dp.length;i++){
            for (int j=1;j<dp[i].length;j++){
                dp[i][j] = j >= w[i] ? Math.max(dp[i][j-1], dp[i-1][j-w[i]] + c[i]) : dp[i-1][j];
            }
        }
        return dp[n-1][V];
    }
}
