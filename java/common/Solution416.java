package common;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */

public class Solution416 {

    private boolean f(int[] nums, int i, int sum, int ss){
        if (i == nums.length){
            if (ss/2 == sum)   return true;
            else return false;
        }
        return f(nums, i+1, sum, ss) || f(nums, i+1, sum + nums[i], ss);
    }

    public boolean canPartition(int[] nums) {
        int ss = 0;
        for (int num : nums)    ss+=num;
        if (ss%2 != 0)  return false;
        return f(nums, 0, 0, ss);
    }

}
