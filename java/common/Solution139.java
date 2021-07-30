package common;

import java.util.HashMap;
import java.util.List;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */

/**
 * 使用dp存储以当前字符结尾的字符串是否可以进行拆分
 * 当判断以 i 结尾的字符串是否可以拆分时，遍历i~0,判断某个节点之前的字符串是否可以拆分以及节点之后到当前节点的字符串是否包含在wordDict中
 */
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String value : wordDict) {
            map.put(value, 1);
        }
        int[] dp = new int[s.length()];
        for (int i=0;i<s.length();i++){
            if (map.containsKey(s.substring(0, i+1))){
                dp[i]=1;
                continue;
            }
            int flag = 0;
            for (int j=i-1;j>=0;j--){
                if (dp[j]==0) continue;
                if (map.containsKey(s.substring(j+1, i+1))){
                    flag = 1;
                    break;
                }
            }
            if (flag == 1)  dp[i]=1;
        }
        return dp[dp.length - 1] == 1;
    }
}
