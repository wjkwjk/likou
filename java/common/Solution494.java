package common;

import java.util.*;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class Solution494 {

    /**
     * 使用hashmap记录，键为到当前元素之前，出现过的和，值为对应的出现该和的组合次数
     * @param nums
     * @param target
     * @return
     */

    public int findTargetSumWays(int[] nums, int target) {

        List<HashMap<Integer, Integer>> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        if (!map.containsKey(-1 * nums[0]))  map.put(-1 * nums[0], 1);
        else    map.put(-1 * nums[0], map.get(-1 * nums[0]) + 1);
        list.add(map);
        int sum = 0;

        for (int i=1;i<nums.length;i++){
            HashMap<Integer, Integer> m = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : list.get(i-1).entrySet()){
                if (!m.containsKey(entry.getKey() + nums[i]))   m.put(entry.getKey() + nums[i], entry.getValue());
                else m.put(entry.getKey() + nums[i], m.get(entry.getKey() + nums[i]) + entry.getValue());
                if (!m.containsKey(entry.getKey() - nums[i]))   m.put(entry.getKey() - nums[i], entry.getValue());
                else m.put(entry.getKey() - nums[i], m.get(entry.getKey() - nums[i]) + entry.getValue());
            }
            list.add(m);
        }

        for (Map.Entry<Integer, Integer> entry : list.get(nums.length-1).entrySet()){
            if (entry.getKey() == target)   sum += entry.getValue();
        }
        return sum;
    }

}
