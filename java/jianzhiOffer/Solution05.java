package jianzhiOffer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */

public class Solution05 {

    public String replaceSpace(String s) {
        StringBuilder r = new StringBuilder();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) != ' ') r.append(s.charAt(i));
            else r.append("%20");
        }
        return r.toString();
    }

}
