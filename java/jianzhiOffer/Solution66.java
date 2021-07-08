package jianzhiOffer;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class Solution66 {
    public int[] constructArr(int[] a) {
        int[] pre = new int[a.length];
        if (a.length==0)    return pre;
        pre[0] = 1;
        for (int i=1;i<pre.length;i++){
            pre[i] = pre[i-1] * a[i-1];
        }
        int next = 1;
        for (int i=pre.length-2;i>=0;i--){
            int temp = next * a[i+1];
            next = temp;
            pre[i]*=next;
        }
        return pre;
    }

}
