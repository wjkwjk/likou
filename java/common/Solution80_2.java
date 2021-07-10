package common;

/**
 * 80. 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Solution80_2 {
    public int removeDuplicates(int[] nums) {
        int last = Integer.MAX_VALUE;
        int lastnum=0;
        int forward = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] == last){
                if (lastnum >= 2){
                    forward++;
                }else{
                    lastnum++;
                }
            }
           else{
               lastnum = 1;
               last = nums[i];
            }
            nums[i-forward] = nums[i];
        }
        return nums.length - forward;
    }
}
