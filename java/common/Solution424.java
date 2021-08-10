package common;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 424. 替换后的最长重复字符
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 */

public class Solution424 {

    //滑动窗口
    public int characterReplacement2(String s, int k){
        int[] nums = new int[26];
        int left = 0, right = 0;
        int maxCharNum = 0;
        for (;right<s.length();right++){
            nums[s.charAt(right) - 'A']++;
            maxCharNum = Math.max(maxCharNum, nums[s.charAt(right) - 'A']);
            if (maxCharNum + k < right - left + 1){
                nums[s.charAt(left) - 'A']--;
                left++;
            }
        }
        //因为，窗口只会变大不会缩小，因此即使中间产生了最大值，那么窗口在之后就会一直右移，但是不会改变尺寸
        return right - left;
    }


    //使用暴力法，判断每个子串内，是否符合条件
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int maxlen = Integer.MIN_VALUE;

        for (int i=0;i<s.length();i++){
            if (s.length() - i <= maxlen)   return maxlen;
            Map<Character, Integer> mapClone = (Map<Character, Integer>) DeepClone.deepClone(map);
            for (int j=s.length()-1;j>=i;j--){
                if (j-i+1 <= maxlen)    break;
                int m = 0;
                int sum = 0;
                for (Map.Entry<Character, Integer> entry : mapClone.entrySet()){
                    m = Math.max(m, entry.getValue());
                    sum += entry.getValue();
                }
                if (sum-m <= k){
                    maxlen = Math.max(maxlen, j-i+1);
                    break;
                }
                mapClone.put(s.charAt(j), mapClone.get(s.charAt(j))-1);
            }
            map.put(s.charAt(i), map.get(s.charAt(i))-1);
        }
        return maxlen;
    }

    static class DeepClone{
        static Object deepClone(Object o){
            Object t = null;
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(o);
                oos.close();
                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                t = ois.readObject();
                ois.close();
            }catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return t;
        }
    }

}

