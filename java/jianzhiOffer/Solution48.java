package jianzhiOffer;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 */

public class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0)  return 0;
        int r = 1;
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i=1;i<s.length();i++){
            dp[i] = dp[i-1]+1;
            for (int j=i-dp[i-1];j<i;j++){
                if (s.charAt(j) == s.charAt(i)){
                    dp[i] = i-j;
                    break;
                }
            }
            r = Math.max(r, dp[i]);
        }
        return r;
    }
}
