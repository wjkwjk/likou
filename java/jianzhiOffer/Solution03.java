package jianzhiOffer;

import java.util.HashMap;

/**
 * 剑指 Offer 03. 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
 */
public class Solution03 {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Boolean> dict = new HashMap<Integer, Boolean>();
        for(int i=0;i<nums.length;i++){
            if(dict.get(nums[i])==null){
                dict.put(nums[i],true);
            }
            else{
                return nums[i];
            }
        }
        return -1;
    }
    public int findRepeatNumber2(int[] nums) {
        int[] loc = new int[100000];
        for(int i=0;i<nums.length;i++){
            if (loc[nums[i]]==0)    loc[nums[i]]=1;
            else    return nums[i];
        }
        return -1;
    }
}