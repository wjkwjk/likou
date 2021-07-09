package common;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 */

class ListNode{
    int val;
    ListNode next;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution92_2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode addpre = new ListNode(Integer.MAX_VALUE, head);
        ListNode p = addpre;
        int index = -1;
        ListNode pre = null, next = null;
        while (p!=null){
            if (index + 1 == left-1)  pre = p;
            if (index == right-1) next = p;
            p = p.next;
            index++;
        }
        if (next.next==null)    next.next = new ListNode(Integer.MAX_VALUE, null);

        ListNode first = pre.next;
        ListNode last = next;
        next = next.next;
        ListNode x = first;
        ListNode k = first.next, t=first.next.next;
        first.next = next;
        pre.next = last;
        while (true){
            if (k==next)    break;
            k.next = first;
            first = k;
            k = t;
            t = t.next;
        }

        if (next.val == Integer.MAX_VALUE)  x.next = null;
        return addpre.next;


    }
}
