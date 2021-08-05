package common;

/**
 * 334. 递增的三元子序列
 * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
 *
 * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
 */

public class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int i = 0, j = 0, k = 0;
        int t = 0;
        for (; k<nums.length; k++){
            if (i==j){
                if (nums[k] <= nums[i]){
                    i = k;
                    j = k;
                }else {
                    j = k;
                }
            }else {
                if (nums[k] > nums[j])  return true;
                else if (nums[k] <= nums[j] && nums[k] > nums[i]){
                    j = k;
                }
                else {//当前遍历的元素小于当前生成的子序列全部元素时
                    if (nums[k] <= nums[t]) t = k;
                    else if (nums[k] > nums[t]){
                        i = t;
                        j = k;
                    }
                }
            }
        }
        return false;
    }
}
