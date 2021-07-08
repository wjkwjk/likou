package jianzhiOffer;

import java.util.List;
import java.util.Stack;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */

class list{
    list next = null;
    int val;

    public list(int val) {
        this.val = val;
    }
}

class MaxQueue {

    private list head = null;
    private list tail = null;
    private int maxv = Integer.MIN_VALUE;

    public MaxQueue() {
    }

    public int max_value() {
        if (maxv==Integer.MIN_VALUE) return -1;
        return maxv;
    }

    public void push_back(int value) {

        list nl = new list(value);

        if (head==null){
            head = nl;
            tail = nl;
            maxv = nl.val;
        }
        else{
            tail.next =nl;
            tail = nl;
            if (maxv<nl.val){
                maxv = nl.val;
            }
        }
    }

    public int pop_front() {
        if (head==null) return -1;
        int r = head.val;
        if (head.val!=maxv){
            head = head.next;
        }
        else{
            list x = head.next;
            maxv = Integer.MIN_VALUE;
            while (x!=null){
                if (x.val>maxv){
                    maxv = x.val;
                }
                x = x.next;
            }
            head = head.next;
        }
        return r;
    }
}

public class Solution59_2 {
    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(1);
        int param_3 = obj.pop_front();
    }
}
//["MaxQueue","max_value","pop_front","pop_front","push_back","push_back","push_back","pop_front","push_back","pop_front"]
//[[],[],[],[],[94],[16],[89],[],[22],[]]