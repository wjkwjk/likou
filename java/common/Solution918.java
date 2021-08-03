package common;

/**
 * 首先使用普通计算没有环路时的最大值
 * 然后思考：如果需要环路，那必定是包括了nums[0]和nums[nums.length-1]，因此只需计算nums[1]~nums[nums.length-2]中最小的连续子数组，然后使用整个nums数组的
 * 和减去该数值即可
 * 最后比较二者的最大值
 */
public class Solution918 {

    private int f(int[] nums, int start, int end){
        int[] dp = new int[nums.length];
        int minc = Integer.MAX_VALUE;
        for (int i=start;i<=end;i++){
            dp[i] = i==start ? nums[i] : Math.min(dp[i-1]+nums[i], nums[i]);
            minc = Math.min(minc, dp[i]);
        }
        //处理当数组长度为1或2时，无需处理环路的情况
        if (minc == Integer.MAX_VALUE)   minc = 0;
        return minc;
    }

    public int maxSubarraySumCircular(int[] nums) {
        int[] dp = new int[nums.length];

        int sum = 0;
        int maxNoC = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            dp[i] = i==0 ? nums[i] : Math.max(dp[i-1]+nums[i], nums[i]);
            maxNoC = Math.max(maxNoC, dp[i]);
        }
        return Math.max(sum - f(nums, 1, nums.length-2), maxNoC);
    }
}
