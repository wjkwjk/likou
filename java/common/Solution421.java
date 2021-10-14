package common;

import java.util.Map;

/**
 * 421. 数组中两个数的最大异或值
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 *
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 */
public class Solution421 {
    public int findMaximumXOR(int[] nums) {
        int maxn = 0;
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                maxn = Math.max(maxn, nums[i] ^ nums[j]);
            }
        }
        return maxn;
    }
}
