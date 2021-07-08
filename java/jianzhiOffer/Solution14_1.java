package jianzhiOffer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution14_1 {
    /**
     * 剑指 Offer 14- I. 剪绳子
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     */

    /**
     * N[i]代表将长度为 i 的绳子进行切分，最后每段相乘得到的最大值
     * N[1], N[2], N[3]不为 1， 1， 2 的原因是：他们切分后的乘积小于本身的长度，因此在更长的绳子中，长度为2，3就不用进行切分了
     * @param n
     * @return
     */

    public int cuttingRope(int n) {
        if (n==2)   return 1;
        if (n==3)   return 2;
        int[] N = new int[n+1];
        N[1] = 1;
        N[2] = 2;
        N[3] = 3;
        for (int i=4;i<=n;i++){
            N[i] = i;
            for (int j=1;j<=i/2;j++){
                N[i] = Math.max(N[i], j*N[i-j]);
            }
        }
        return N[n];
    }
}
