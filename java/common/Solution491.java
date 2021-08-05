package common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class Solution491 {

    private void F(int[] nums, List<List<Integer>>L, List<Integer> t, int index){
        if (index == nums.length){
            if (t.size() > 0)   L.add(new ArrayList<>(t));
            return;
        }
        F(nums, L, t, index+1);
        if (t.size()==0 || nums[index]>=t.get(t.size()-1)){
            t.add(nums[index]);
            F(nums, L, t, index+1);
            t.remove(t.size()-1);
        }
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> L = new ArrayList<>();
        List<Integer> t = new ArrayList<>();
        F(nums, L, t, 0);
        //使用Set去重
        HashSet<List<Integer>> set = new HashSet<>(L);
        return new ArrayList<>(set);
    }
}
