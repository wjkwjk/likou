package common;

/**
 * 790. 多米诺和托米诺平铺
 * 有两种形状的瓷砖：一种是 2x1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 *
 * XX  <- 多米诺
 *
 * XX  <- "L" 托米诺
 * X
 * 给定 N 的值，有多少种方法可以平铺 2 x N 的面板？返回值 mod 10^9 + 7。
 *
 * （平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。）
 */
public class Solution790 {
    public int numTilings(int n) {
        int X = (int) (Math.pow(10, 9) + 7);
        if (n<=0)   return 0;
        if (n==1)   return 1;
        long[][] dp = new long[n][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[1][0] = 2;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for (int i=2;i<dp.length;i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-2][0]) % X;
            dp[i][1] = (dp[i-2][0] + dp[i-1][2]) % X;
            dp[i][2] = (dp[i-2][0] + dp[i-1][1]) % X;
        }
        return (int) dp[n-1][0];
    }
}
