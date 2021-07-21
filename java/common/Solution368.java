package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int maxv=0;
        int index = 0;
        int[] r = new int[nums.length];
        for (int i=0;i<r.length;i++)    r[i] = 1;
        for (int i=0;i<nums.length;i++){
            int t = 0;
            for (int j=i-1;j>=0;j--){
                if (nums[i] % nums[j] ==0)  t = Math.max(t, r[j]);
            }
            r[i]+=t;
            if (r[i]>maxv){
                maxv = r[i];
                index = i;
            }
        }
        ArrayList<Integer> L = new ArrayList<>();
        for(int i=index;i>=0;i--){
            if (nums[index] % nums[i]==0)  L.add(nums[i]);
        }
        return L;
    }
}
