package common;

import java.util.Arrays;

/**
 * 556. 下一个更大元素 III
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 */


public class Solution556 {

    /**
     * 思路是遍历字符串中的每个字符对，如果字符对是正序排列（string[i]<string[j],i<j），那么通过交换二者顺序，一定可以使得
     * 交换后的数组大于交换前的数字，同时因为第i个位置上的数字从string[i]变成了string[j]，因此 i 后面的数字使用最小的顺序排序，即升序排序
     */
    public static int nextGreaterElement(int n) {
        StringBuilder sn = new StringBuilder(Integer.toString(n));
        long minV = Long.MAX_VALUE;
        StringBuilder s;
        for (int i=0;i<sn.length();i++){
            for (int j=i+1;j<sn.length();j++){
                if(sn.charAt(i) < sn.charAt(j)){     //交换正序排列的两个数字
                    s = new StringBuilder(sn.toString());
                    char c = s.charAt(i);
                    s.setCharAt(i, sn.charAt(j));
                    s.setCharAt(j, c);
                    char[] chars = s.toString().toCharArray();
                    Arrays.sort(chars, i+1, s.length());   //将之后的数字升序排列
                    if (Long.parseLong(String.valueOf(chars)) <= Integer.MAX_VALUE){
                        minV = Math.min(minV, Integer.parseInt(String.valueOf(chars)));
                    }
                }
            }
        }
        if (minV == Long.MAX_VALUE) return -1;
        else return (int)minV;
    }


    public static int nextGreaterElement2(int n){
        StringBuilder sn = new StringBuilder(Integer.toString(n));
        int p = -1;
        for (int i=sn.length()-1;i>0;i--){
            if (sn.charAt(i) > sn.charAt(i-1)){
                p = i - 1;
                break;
            }
        }
        if (p == -1)    return -1;
        int index = p;
        char minv = '9';
        for (int i=p+1;i<sn.length();i++){
            if (sn.charAt(i) > sn.charAt(p) && sn.charAt(i) <= minv){
                minv = sn.charAt(i);
                index = i;
            }
        }
        char c = sn.charAt(index);
        sn.setCharAt(index, sn.charAt(p));
        sn.setCharAt(p, c);
        char[] chars = sn.toString().toCharArray();
        Arrays.sort(chars, p+1, sn.length());
        if (Long.parseLong(String.valueOf(chars)) > Integer.MAX_VALUE)  return -1;
        return (int)(Long.parseLong(String.valueOf(chars)));
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElement2(123456789));
    }
}
