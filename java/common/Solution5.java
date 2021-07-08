package common;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class Solution5 {

    int start = 0;
    int end = 0;

    int search(int start, int end, String s, int flag){
        if (start==end) return 1;
        if (start>end)  return 0;
        if (s.charAt(start) == s.charAt(end)){
            int t = search(start+1, end-1, s, 1);
            if (t != 0 || (t==0 && end-start==1)){
                if (this.end - this.start + 1 < t+2){
                    this.end = end;
                    this.start = start;
                }
                return t+2;
            }
        }
        if (flag==0){
            int t = Math.max(search(start+1, end,s, 0), search(start, end-1, s, 0));
            return Math.max(t, search(start+1, end-1, s, 0));
        }
        return 0;
    }

    //递归法
    public String longestPalindrome(String s) {
        search(0, s.length()-1, s, 0);
        return s.substring(this.start, this.end+1);
    }

    //动规法
    public String longestPalindrome2(String s){
        int start = 0;
        int end = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i=0;i<s.length();i++)  dp[i][i]=1;
        for (int j=1;j<s.length();j++){
            for (int i=0;i<s.length()-j;i++){
                dp[i][i+j] = (dp[i+1][i+j-1]!=0 && s.charAt(i)==s.charAt(i+j))||(j==1 && s.charAt(i)==s.charAt(i+j)) ? dp[i+1][i+j-1]+2 : 0;
                if (end - start + 1 < dp[i][i+j]){
                    end = i+j;
                    start = i;
                }
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        Solution5 s=new Solution5();
        s.longestPalindrome2("cbbd");
    }

}
