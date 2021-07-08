package jianzhiOffer;

/**
 * 剑指 Offer 16. 数值的整数次方
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */

/**
 * 使用二分法进行计算，需要注意的是：
 *  当 n=-2147483648时，n==-n为true，因为是由补码编码
 */
public class Solution16 {
    public double myPow(double x, int n) {
        long m = (long)n;
        if (m<0){
            x = 1/x;
            m=-m;
        }
        if (m==0 || x==1)   return 1;
        return cal_mi(x, m);
    }

    public double cal_mi(double x, long n){
        if (n==0)   return 1;
        if (n%2==0){
            double t = cal_mi(x, n/2);
            return t*t;
        }
        else {
            double t = cal_mi(x, (n-1)/2);
            return x * t * t;
        }
    }

    public static void main(String[] args) {
        Solution16 s = new Solution16();
        System.out.println(s.myPow(2.00000,-2147483648));
    }
}
