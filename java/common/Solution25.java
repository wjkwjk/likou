package common;

import java.util.List;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 进阶：
 *
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 */
public class Solution25 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     *
     * @param pre    当前反转子链表的前一个节点（即当前子链表第一个节点的前一个节点）
     * @param last   当前饭庄子链表的最后一个节点（不是最后一个节点的后一个节点，指的就是最后一个节点）
     * @return
     */
    ListNode reverse(ListNode pre, ListNode last){
        ListNode first = pre.next;
        ListNode lastnext = last.next;
        ListNode h = first;
        pre.next = last;
        ListNode next = first.next, nextnext;
        while (first != last){
            nextnext = next.next;
            next.next = first;
            first = next;
            next = nextnext;
        }
        h.next = lastnext;
        return h;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode pre = new ListNode();
        pre.next = head;
        int x = 0;
        ListNode H = null;
        int flag = 1;
        while (head != null){
            x++;
            if (x == k){
                if (flag == 1){
                    flag = 0;
                    H = head;
                }
                pre = reverse(pre, head);
                head = pre.next;
                x = 0;
            }
            else    head = head.next;
        }
        return H;
    }

    public static void main(String[] args) {
        Solution25 s = new Solution25();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        s.reverseKGroup(a, 3);
    }
}
