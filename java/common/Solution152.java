package common;

import java.util.ArrayList;

/**
 * 152. 乘积最大子数组
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        int maxn = Integer.MIN_VALUE;
        ArrayList<Integer> list = new ArrayList<>();
        int lastp = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<0)  list.add(i);
            if (nums[i]==0){
                maxn = Math.max(0, maxn);
                if (list.size()%2==0){
                    int t = 1;
                    for (int j = lastp;j<i;j++){
                        t*=nums[j];
                    }
                    maxn = Math.max(maxn, t);
                }else{
                    int t = 1;
                    for (int j=lastp;j<list.get(list.size()-1);j++)    t*=nums[j];
                    maxn = Math.max(maxn, t);
                    t = 1;
                    for (int j = list.get(0)+1; j<i;j++)  t*=nums[j];
                    maxn = Math.max(maxn, t);
                }
                lastp = i+1;
                list.clear();
            }
        }

        if (list.size()%2==0){
            int t = 1;
            for (int j = lastp;j<nums.length;j++){
                t*=nums[j];
            }
            maxn = Math.max(maxn, t);
        }else{
            int t = 1;
            for (int j=lastp;j<list.get(list.size()-1);j++)    t*=nums[j];
            maxn = Math.max(maxn, t);
            t = 1;
            for (int j = list.get(0)+1; j<nums.length;j++)  t*=nums[j];
            maxn = Math.max(maxn, t);
        }
        return maxn;
    }


}
