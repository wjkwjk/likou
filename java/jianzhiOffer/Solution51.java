package jianzhiOffer;

/**
 * 剑指 Offer 51. 数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组，求出这个数组中的逆序对的总数。
 */
public class Solution51 {

    public void guibing_single(int start1, int end1, int start2, int end2, int[] nums){
        int[] temp = new int[end2 - start1 +1];
        int f=start1, s=start2, i=0;
        for (;f<=end1&&s<=end2;i++){
            if (nums[f]<=nums[s])   temp[i] = nums[f++];
            else    temp[i] = nums[s++];
        }
        while (f<=end1) temp[i++] = nums[f++];
        while (s<=end2) temp[i++] = nums[s++];
        for (int k=start1;k<=end2;k++)  nums[k] = temp[k-start1];
    }

    public void guibing(int[] nums){
        for (int i=1;Math.pow(2,i-1)<= nums.length;i++){
            for (int j=0;j<=nums.length;j+=Math.pow(2,i)){
                guibing_single(j, j+(int)Math.pow(2,i-1)-1, j+(int)Math.pow(2,i-1), j+(int)Math.pow(2,i)-1, nums);
            }
        }
    }

    public int reversePairs(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2,6,9,5};
        Solution51 s = new Solution51();
        s.guibing(nums);
    }

}
