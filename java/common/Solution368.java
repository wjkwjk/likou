package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 368. 最大整除子集
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 */
public class Solution368 {

    /**
     * 每个节点记录了当以当前数为最大值时的子集的元素数以及前一个子集的最大元素
     */
    class node{
        int num;
        int pre;

        public node(int num, int pre) {
            this.num = num;
            this.pre = pre;
        }
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        node[] N = new node[nums.length];
        int index = 0;
        int maxi = -1;
        for (int i=0;i<nums.length;i++){
            int maxv = 0;
            int preindex = i;
            for (int j=i-1;j>=0;j--){
                if (nums[i] % nums[j] == 0){
                    if (N[j].num > maxv){
                        maxv = N[j].num;
                        preindex = j;
                    }
                }
            }
            N[i] = new node(maxv + 1, preindex);
            if (N[i].num > maxi){
                maxi = N[i].num;
                index = i;
            }
        }
        ArrayList<Integer> L = new ArrayList<>();
        L.add(nums[index]);
        while (N[index].pre!=index) {
            index = N[index].pre;
            L.add(nums[index]);
        }
        return L;
    }
}
