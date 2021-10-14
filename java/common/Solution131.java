package common;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class Solution131 {

    private boolean isHui(String s, int start, int end){
        for (int i=start;i<=(start + end) / 2;i++){
            if (s.charAt(i) != s.charAt(start + end - i))   return false;
        }
        return true;
    }

    private void split(String s, List<String> list, List<List<String>> allList, int start){
        if (start >= s.length()){
            allList.add(new ArrayList<>(list));
            return;
        }
        for (int i=start;i<s.length();i++){
            if (isHui(s, start, i)){
                list.add(s.substring(start, i+1));
                split(s, list, allList, i+1);
                list.remove(list.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> allList = new ArrayList<>();
        split(s, new ArrayList<>(), allList, 0);
        return allList;
    }
}
