package common;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 229. 求众数 II
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class Solution229 {

    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>();
        for (int num : nums) {
            int n = 0;
            Set<Integer> values = map.keySet();
            if (values.size() >= 2) {
                if (values.contains(num)){
                    map.put(num, map.get(num) + 1);
                }else {
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        if (entry.getValue() - 1 == 0) {
                            map.remove(entry.getKey());
                        } else {
                            map.put(entry.getKey(), entry.getValue() - 1);
                        }
                    }
                }
            } else {
                map.put(num, map.containsKey(num) ? map.get(num) + 1 : 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Integer integer : map.keySet()) {
            int s = 0;
            for (int num : nums) {
                if (num == integer) s++;
            }
            if (s > nums.length / 3)    list.add(integer);;
        }
        return list;
    }

    public static void main(String[] args) {
        Solution229 s = new Solution229();
        for (Integer integer : s.majorityElement(new int[]{1, 1, 1, 2, 2, 3, 3, 3})) {
            System.out.println(integer);
        }
    }
}
