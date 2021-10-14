package common;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。
 */


/**
 * 使用动态规划，dp[i][j]表示word1[i]和word2[j]之前的字符串中，最长公共字符串的长度，这里的公共字符串不要求连续，也不要求以word1[i]和word2[j]结尾
 * 找出最长公共字符串，其余的字符则是需要被删除的
 */
public class Solution583 {
    public int minDistance(String word1, String word2) {
        word1 = "#" + word1;
        word2 = "#" + word2;
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i=1;i<word1.length();i++){
            for (int j=1;j<word2.length();j++){
                dp[i][j] = Math.max(word1.charAt(i) == word2.charAt(j) ? dp[i-1][j-1]+1 : dp[i-1][j-1],
                        Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }
        return word1.length() + word2.length() - 2 - dp[word1.length()-1][word2.length()-1] * 2;
    }
}
