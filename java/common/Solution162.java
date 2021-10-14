package common;

import java.util.Arrays;

/**
 * 162. 寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素。
 *
 * 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞ 。
 */
public class Solution162 {
    /**
     * 使用峰值法
     * 由于题目规定，可以将nums[-1]和nums[nums.length]看成负无穷，因此必定存在峰值
     * 当三个连续的数为增序时，峰值元素位于右侧，为降序时，峰值元素位于左侧，如果为谷底元素，两侧都必有峰值元素
     * 因此我们可以随机选择一个下标，然后判断其左右元素的大小，迭代进行
     * 如果每次选第一个元素，那么复杂度为O(n),可以每次选择中间元素，时间复杂度变为O(logn)
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        long[] newnums = new long[nums.length + 2];
        for (int i=1;i<newnums.length-1;i++)    newnums[i] = nums[i-1];
        newnums[0] = Long.MIN_VALUE;
        newnums[newnums.length-1] = Long.MIN_VALUE;
        int index = newnums.length / 2;
        while (true){
            if (newnums[index-1] < newnums[index] && newnums[index] < newnums[index+1]) index++;
            else if (newnums[index-1] > newnums[index] && newnums[index] > newnums[index+1])    index--;
            else if (newnums[index-1] < newnums[index] && newnums[index] > newnums[index+1])    return index-1;
            else index--;
        }
    }
    

    public static void main(String[] args) {
        Solution162 s = new Solution162();
        System.out.println(s.findPeakElement(new int[]{-2147483648}));
    }
}
