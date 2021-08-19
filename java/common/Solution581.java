package common;

/**
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 */
public class Solution581 {


    /**
     * 找出最大的 i ，使得数组中，位于 i 左侧的元素有序，i 右侧的元素都大于nums[i]
     * 找出最小的 j ，使得数组中，位于 j 右侧的元素有序，j 左侧的元素都小于nums[j]
     * @param nums
     * @return
     */

    public int findUnsortedSubarray(int[] nums) {
        int[] minnums = new int[nums.length];
        for (int i = nums.length-1; i>=0; i--){
            if(i == nums.length-1)  minnums[i] = nums[i];
            else    minnums[i] = Math.min(minnums[i+1], nums[i]);
        }
        int left = -1;
        for (int i = 0; i<nums.length; i++){
            if (i == 0 && nums[i] == minnums[i])    left = i;
            else if (i > 0 && nums[i] >= nums[i-1] && nums[i] == minnums[i])    left = i;
            else break;
        }

        int[] maxnums = new int[nums.length];
        for (int i = 0; i<nums.length; i++){
            if (i == 0) maxnums[i] = nums[i];
            else    maxnums[i] = Math.max(maxnums[i-1], nums[i]);
        }
        int right = nums.length;
        for (int i = nums.length-1; i>=0; i--){
            if (i == nums.length-1 && nums[i] == maxnums[i])    right = i;
            else if (i<nums.length-1 && nums[i] <= nums[i+1] && nums[i] == maxnums[i])  right = i;
            else break;
        }
        if (right - left <= 1)  return 0;
        return right - 1 - left;
    }

}
