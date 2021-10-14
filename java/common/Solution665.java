package common;

/**
 * 665. 非递减数列
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
public class Solution665 {


    /**
     * 暴力，从前往后遍历每一个元素，判断是否存在以该元素为首的逆序对（以同一个元素为首的多个逆序对，通过修改该元素，可以都变成正序对，因此总数加1），如果总数大于1，则无法修改成正序，返回false
     * 另外还需从后往前遍历
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int n = 0;
        //从前往后遍历
        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i] > nums[j]){
                    n++;break;
                }
            }
            if (n > 1)  break;
        }
        if (n <= 1) return true;
        n = 0;
        //从后往前遍历
        for (int i=nums.length-1;i>=1;i--){
            for (int j=i-1;j>=0;j--){
                if (nums[i]< nums[j]){
                    n++;break;
                }
            }
            if (n > 1)  break;
        }
        return n <= 1;
    }

    /**
     * 边遍历数组，边修改数组
     * 如果nums[i+1] < nums[i]，就说明此次是逆序对，因此count++，
     * 如果nums[i+1] >= nums[i-1]，同时，因为num[i]之前已经是正序了，因此nums[i]>nums[i-1],因此 nums[i]> nums[i+1]>nums[i-1],因此把nums[i]设为nums[i+1]，实现最小的正序
     * 如果nums[i+1] < nums[i-1],因此， nums[i] > nums[i-1] > nums[i+1],因此把nums[i+1]设为nums[i]，已实现正序
     * @param nums
     * @return
     */
    public boolean checkPossibility2(int[] nums){
        int count = 0;
        for (int i=0;i<nums.length-1;i++){
            if (nums[i] > nums[i+1]){
                count++;
                if (count > 1)  return false;
                if (i == 0) nums[i] = nums[i+1];
                else {
                    if (nums[i+1] >= nums[i-1]) nums[i] = nums[i+1];
                    else nums[i+1] = nums[i];
                }
            }
        }
        return true;
    }

}
