package common;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 */

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())  return false;
        Map<Character, Integer> maps1 = new HashMap<>();
        int diff = 0;
        for (int i=0;i<s1.length();i++){
            if (!maps1.containsKey(s1.charAt(i))){
                maps1.put(s1.charAt(i), 1);
            }else {
                maps1.put(s1.charAt(i), maps1.get(s1.charAt(i))+1);
            }

            if (!maps1.containsKey(s2.charAt(i))){
                maps1.put(s2.charAt(i), -1);
            }else {
                maps1.put(s2.charAt(i), maps1.get(s2.charAt(i))-1);
            }
        }

        int flag = 0;
        for (Map.Entry<Character, Integer> entry : maps1.entrySet()){
            if (entry.getValue() != 0){
                flag = 1;
                diff += Math.abs(entry.getValue());
            }
        }
        if (flag == 0)  return true;

        for (int i=1;i<=s2.length()-s1.length();i++){
            char first = s2.charAt(i+s1.length()-1);
            char last = s2.charAt(i-1);
            if (maps1.containsKey(first)){
                if (maps1.get(first) <= 0) diff++;
                else diff--;
                maps1.put(first, maps1.get(first)-1);
            }else {
                diff++;
                maps1.put(first, -1);
            }
            if (maps1.get(last) >= 0) diff++;
            else diff--;
            maps1.put(last, maps1.get(last)+1);

            if (diff == 0)  return true;

        }
        return false;
    }
}
