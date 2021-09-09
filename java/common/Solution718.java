package common;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class Solution718 {

    //暴力法
    public int findLength(int[] nums1, int[] nums2) {
        int r = 0;
        int t = 0;
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums1[i] == nums2[j]){
                    int m = i, n = j;
                    while (m<nums1.length && n<nums2.length && nums1[m] == nums2[n]){
                        m++;n++;
                        t++;
                    }
                    r = Math.max(r, t);
                    t = 0;
                }
            }
        }
        return r;
    }

    /**
     * 此题相当于计算最长相同前缀
     * 使用动态规划，使用一个二维数组记录num1[i]和num2[j]的最长相同前缀
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength2(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length][nums2.length];
        int r = 0;
        for (int i=0;i<nums1.length;i++){
            if (nums1[i] == nums2[0]){
                dp[i][0] = 1;
                r = Math.max(r, dp[i][0]);
            }
        }
        for (int j=0;j<nums2.length;j++){
            if (nums1[0] == nums2[j]){
                dp[0][j] = 1;
                r = Math.max(r, dp[0][j]);
            }
        }
        for (int i=1;i<nums1.length;i++){
            for (int j=1;j<nums2.length;j++){
                dp[i][j] = nums1[i] != nums2[j] ? 0 : dp[i-1][j-1]+1;
                r = Math.max(r, dp[i][j]);
            }
        }
        return r;
    }

    /**
     * 通过滑动窗口实现，即一个数组滑动，使得num1[i]与num2[j]对齐
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength3(int[] nums1, int[] nums2){
        int r = 0;
        int t = 0;
        for (int i=0;i<nums1.length;i++){      //将num2向后滑动，分别于num1中的每个元素进行对齐
            int flag = 0;
            t = 0;
            for (int j=0;j<nums2.length && i+j<nums1.length;j++){
                if (flag == 0){
                    if (nums2[j] == nums1[i+j]){
                        flag = 1;
                        r = Math.max(r, ++t);
                    }
                }else {
                    if (nums2[j] == nums1[i+j]){
                        r = Math.max(r, ++t);
                    }else {
                        flag = 0;
                        t = 0;
                    }
                }
            }
        }
        for (int i=0;i<nums2.length;i++){       //将num1向后滑动，分别于num2中的每个元素进行对齐
            int flag = 0;
            t = 0;
            for (int j=0;j<nums1.length && i+j<nums2.length;j++){
                if (flag == 0){
                    if (nums1[j] == nums2[i+j]){
                        flag = 1;
                        r = Math.max(r, ++t);
                    }
                }else {
                    if (nums1[j] == nums2[i+j]){
                        r = Math.max(r, ++t);
                    }else {
                        flag = 0;
                        t = 0;
                    }
                }
            }
        }
        return r;
    }


}
