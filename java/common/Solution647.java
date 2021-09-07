package common;

/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * 回文字符串 是正着读和倒过来读一样的字符串。
 *
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class Solution647 {

    private boolean isHui(int i, int j, String s){
        for (;i<=j;i++,j--){
            if (s.charAt(i)!=s.charAt(j))   return false;
        }
        return true;
    }

    public int countSubstrings(String s) {
        int sum = 0;
        for (int i=0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                if (isHui(i,j,s))   sum++;
            }
        }
        return sum;
    }

    public int countSubstrings2(String s) {
        int sum = 0;
        for (int i=0;i<s.length();i++){
            int l = i, r = i;
            for (;l>=0 && r<s.length() &&s.charAt(l)==s.charAt(r);l--,r++);
            sum += r - i;
            l = i; r = i + 1;
            for (;l>=0 && r<s.length() &&s.charAt(l)==s.charAt(r);l--,r++);
            sum += r - i - 1;
        }
        return sum;
    }
}
