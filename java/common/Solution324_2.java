package common;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 *
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 */
public class Solution324_2 {


    /**
     * 先排序，然后找到中位数，将右边的数插在左边数组中
     * 这种情况会有一个问题：由于题目要求结果是严格排序，因此会出现两个相同的数相邻
     * 由于两个数组各隔一个进行插入，因此数组内部的重复元素不会导致上面这种情况，只有可能两个数组出现了相同的数，但是由于两个数组
     * 是根据中位数划分的，因此若存在相同数，那必是左边数组的最大值等于右边数组的最小值，因此可以两个数组分别进行逆序插入
     * @param nums
     */

    public void wiggleSort(int[] nums) {
        int[] newnums = new int[nums.length];
        Arrays.sort(nums);
        int i = nums.length%2==0?nums.length/2:nums.length/2+1;
        int k=0;
        int flag = 1;
        for (int j=0;j<i;){
            if (flag == 0){
                newnums[j+k] = nums[nums.length -1 - k];
                k++;
                flag = 1;
            }else{
                newnums[j+k] = nums[i- 1 - j];
                flag = 0;
                j++;
            }
        }
        if(nums.length%2==0) newnums[newnums.length-1] = nums[i];
        for(int j=0;j<nums.length;j++)  nums[j] = newnums[j];
    }


    /**
     * 排序时间复杂度较高，但是我们只要找到数组的中位数，使得数组划分为左右两个子数组，
     * 同时使得左边数组的最大值位于最右侧，右边数组的
     * 最小值位于最左侧
     * 找中位数可以用快排的思想
     * @param nums
     */

    int partion(int low, int high, int[] nums, int privot){
        int l=low, h=high;
        while (l < h){
            while (nums[h] >= nums[privot] && l<h) h--;
            while (nums[l] <= nums[privot] && l<h) l++;
            if (l<h){
                int temp = nums[l];
                nums[l] = nums[h];
                nums[h] = temp;
            }
        }
        int temp = nums[l];
        nums[l] = nums[privot];
        nums[privot] = temp;
        return l;
    }


    public static void main(String[] args) {
        Solution324_2 s  = new Solution324_2();
//        s.wiggleSort(new int[]{1,1,1,4,5});
        int[] nums = new int[]{6,5,5,4};
    }
}

// 1 1 1 4 5 6
// 1 4 1