package jianzhiOffer;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。
 * 队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
 * (若队列中没有元素，deleteHead 操作返回 -1 )
 */

public class Solution09 {
}

class CQueue {

    Stack<Integer> S1;
    Stack<Integer> S2;

    public CQueue() {
        S1 = new Stack<>();
        S2 = new Stack<>();
    }

    public void appendTail(int value) {
        S1.push(value);
    }

    public int deleteHead() {
        if (!S2.empty())    return S2.pop();
        while (!S1.empty()){
            S2.push(S1.pop());
        }
        int r = -1;
        if (!S2.empty()) r = S2.pop();
        return r;
    }
}