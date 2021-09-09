package common;

/**
 * 713. 乘积小于K的子数组
 * 给定一个正整数数组 nums和整数 k 。
 *
 * 请找出该数组内乘积小于 k 的连续的子数组的个数。
 */
public class Solution713 {

    //暴力，遍历每个连续子数组
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int sum = 0;
        int last;
        for (int i=0;i<nums.length;i++){
            last = 1;
            for (int j=i;j<nums.length;j++){
                if (last == -1) break;
                last *= nums[j];
                if (last >= k)  last = -1;
                else sum++;
            }
        }
        return sum;
    }

    /**
     * 使用滑动窗口，每次记录以right为右端点的满足条件的连续子数组的个数
     * @param nums
     * @param k
     * @return
     */

    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int sum = 0;
        int temp = 1;
        for (int i=0,j=0;i<nums.length && j<nums.length;j++){
            temp *= nums[j];
            while (temp >= k) temp /= nums[i++];
            sum += j - i + 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution713 s = new Solution713();
        System.out.println(s.numSubarrayProductLessThanK2(new int[]{1,2,3}, 0));
    }

}
