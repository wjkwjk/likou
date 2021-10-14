package common;

/**
 * 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 *  并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false
 */
public class Solution456 {

    public boolean find132pattern1(int[] nums){
        return false;
    }


    public boolean find132pattern(int[] nums) {
        if (nums.length <= 2)   return false;
        int premin = Integer.MAX_VALUE;
        int heap = -1;
        int i=0;
        for (i=0;i<nums.length;i++){
            if (i > 0 && nums[i] < nums[i-1]){
                heap = nums[i-1];
                break;
            }
            premin = Math.min(premin, nums[i]);
        }
        if (heap == -1) return false;
        int nextpremin = premin;
        for (;i<nums.length;i++){
            nextpremin = Math.min(premin, nums[i]);
            if (nums[i] > heap){
                heap = nums[i];
                premin = nextpremin;
            }else if (nums[i] < heap){
                if (nums[i] > premin){
                    return true;
                }
            }
        }
        return false;
    }
}
