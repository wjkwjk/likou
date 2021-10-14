package common;

import java.util.*;

/**
 * 791. 自定义字符串排序
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 *
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 *
 * 返回任意一种符合条件的字符串T。
 */
public class Solution791 {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Integer, Character> map1 = new HashMap<>();
        int n = 0;
        for (int i=0;i<order.length();i++){
            if (!map.containsKey(order.charAt(i))){
                map.put(order.charAt(i), n);
                map1.put(n, order.charAt(i));
                n++;
            }
        }
        int[] nums = new int[s.length()];
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), n);
                map1.put(n, s.charAt(i));
                n++;
            }
            nums[i] = map.get(s.charAt(i));
        }
        Arrays.sort(nums);
        StringBuilder stringBuilder = new StringBuilder();
        for (int num : nums) {
            stringBuilder.append(map1.get(num));
        }
        return stringBuilder.toString();
    }
    public String customSortString2(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = 0;
        for (int i=0;i<order.length();i++){
            if (!map.containsKey(order.charAt(i))){
                map.put(order.charAt(i), n++);
            }
        }
        Map<Integer, ArrayList<Character>> mapn = new HashMap();
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), n++);
            }
            if (!mapn.containsKey(map.get(s.charAt(i)))){
                mapn.put(map.get(s.charAt(i)), new ArrayList<Character>());
            }
            mapn.get(map.get(s.charAt(i))).add(s.charAt(i));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer, ArrayList<Character>> entry : mapn.entrySet()){
            for (Character character : entry.getValue()) {
                stringBuilder.append(character);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution791 s = new Solution791();
        s.customSortString2("cba", "abcd");
    }

}
