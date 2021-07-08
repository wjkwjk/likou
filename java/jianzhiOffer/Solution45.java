package jianzhiOffer;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 121 12
 */

public class Solution45 {
    public String minNumber(int[] nums) {
        String[] nums_str = new String[nums.length];
        for (int i=0;i<nums.length;i++) nums_str[i] = String.valueOf(nums[i]);
        Arrays.sort(nums_str, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1+s2).compareTo(s2+s1)<=0?-1:1;
            }
        });
        String r = "";
        for (int i=0;i<nums_str.length;i++)
            r+=nums_str[i];
        return r;
    }

    public static void main(String[] args) {
        Solution45 s = new Solution45();
        int[] nums = new int[]{3,30,34,5,9};
        s.minNumber(nums);


    }
}
