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


    /**
     * 使用01背包问题的思路解决，01背包中，dp[i][j]表示放第i件物品时，总重量小于等于j时的最大总价值；
     * 这里的dp[i][j]表示，加第i个数字时，是否可以使得总和为j
     * @param nums
     * @return
     */

    public boolean canPartition2(int[] nums) {
        int ss = 0;
        for (int num : nums)    ss+=num;
        if (ss%2 != 0)  return false;
        boolean[][] dp = new boolean[nums.length][ss/2+1];

        for (int j=0;j<dp[0].length;j++)    dp[0][j] = j == nums[0];
        if (dp[0][dp[0].length-1])  return true;
        dp[0][0] = true;

        for (int i=1;i<dp.length;i++){
            dp[i][0] = true;    //只要不选任何数，那么就可以实现总和为0，因此dp[i][0]比为true
            //这里的思路和01背包基本一样，只不过01背包要选最大值，而这里进行或运算
            for (int j=1;j<dp[i].length;j++){
                dp[i][j] = j >= nums[i] ? dp[i-1][j-nums[i]] || dp[i-1][j] : dp[i-1][j];
            }
            if (dp[i][dp[i].length-1])  return true;
        }
        return false;
    }
}
