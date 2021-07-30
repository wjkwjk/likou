package common;

/**
 * 63. 不同路径 II
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 */

public class Solution63_2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][];
        for (int i=0;i<obstacleGrid.length;i++){
            dp[i] = new int[obstacleGrid.length];
            for (int j=0;j<dp[i].length;j++){
                if (obstacleGrid[i][j] == 1)    dp[i][j] = 0;
                else if (i==0 && j==0)   dp[i][j] = 1;
                else{
                    int top = i-1>=0 ? dp[i-1][j] : 0;
                    int left = j-1>=0 ? dp[i][j-1] : 0;
                    dp[i][j] = top + left;
                }
            }
        }
        return dp[dp.length-1][dp[dp.length-1].length-1];
    }
}
