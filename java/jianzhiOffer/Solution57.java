package jianzhiOffer;

/**
 * 剑指 Offer II 057. 值和下标之差都在给定的范围内
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 */

public class Solution57 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<=i+k && j<nums.length;j++){
                if (Math.abs((long)nums[i] - (long)nums[j]) <= t){
                    return true;
                }
            }
        }
        return false;
    }

}
