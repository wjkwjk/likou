package common;

/**
 * 397. 整数替换
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 */
public class Solution397 {

    //动规，超出空间限制
    //java的数组长度最大为int上限
    public int integerReplacement(int n) {
        long[] dp = new long[n+1];
        dp[1] = 0;

        for (int i=2;i<dp.length;i++){
            if (i % 2 == 0){
                dp[i] = dp[i/2] + 1;
            }else {
                dp[i] = Math.min(dp[i-1], dp[(i+1)/2+1]) + 1;
            }
        }
        return (int) dp[n];
    }

    private long f(long n){
        if (n==1)   return 0;
        if (n % 2 == 0) return f(n/2) + 1;
        else return Math.min(f(n+1), f(n-1))+1;
    }

    public int integerReplacement2(int n) {
        return (int)f((long)n);
    }

}
