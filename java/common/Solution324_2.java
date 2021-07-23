package common;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
public class Solution324_2 {
    public void wiggleSort(int[] nums) {
        int[] newnums = new int[nums.length];
        Arrays.sort(nums);
        int i = nums.length%2==0?nums.length/2:nums.length/2+1;
        int k=0;
        int flag = 1;
        for (int j=0;j<i;){
            if (flag == 0){
                newnums[j+k] = nums[i+k];
                k++;
                flag = 1;
            }else{
                newnums[j+k] = nums[j];
                flag = 0;
                j++;
            }
        }
        nums = newnums;
    }

    public static void main(String[] args) {
        Solution324_2 s  = new Solution324_2();
        s.wiggleSort(new int[]{1,1,1,4,5});
    }
}

// 1 1 1 4 5 6
// 1 4 1