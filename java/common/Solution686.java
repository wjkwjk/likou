package common;

/**
 * 686. 重复叠加字符串匹配
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 *
 * 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。
 */

public class Solution686 {

    public int repeatedStringMatch(String a, String b) {
        int maxl = (int) (Math.ceil((a.length() + b.length() - 1) / (double)a.length()));
        StringBuilder as = new StringBuilder(a);
        while (--maxl > 0){
            as.append(a);
        }
        int i = 0;
        int flag = 1;
        for (;i<a.length();i++){
            flag = 1;
            for (int j = 0;j<b.length();j++){
                if (b.charAt(j) != as.charAt(j+i)){
                    flag = 0;
                    break;
                }
            }
            if (flag == 1)break;
        }
        if (flag == 0)  return -1;
        return (int) Math.ceil((i + b.length()) / (double)a.length());
    }

    public static void main(String[] args) {
        Solution686 s = new Solution686();
        System.out.println(s.repeatedStringMatch("abc", "wxyz"));
    }

}
