package jianzhiOffer;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 */

public class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> S = new Stack<Integer>();
        int index = 0;
        for (int i=0;i<popped.length;i++){
            if (S.empty() || S.peek()!=popped[i]){
                int j = index;
                for (;j<pushed.length;j++){
                    if (pushed[j]!=popped[i])   S.push(pushed[j]);
                    else    break;
                }
                if (j == pushed.length) return false;
                index = j+1;
            }
            else    S.pop();
        }
        return true;
    }
}
