package common;

import java.util.List;

/**
 * 725. 分隔链表
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 */
public class Solution725 {
    public static void main(String[] args) {

    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] r = new ListNode[k];
        ListNode h = head;
        int num = 0;
        while (h != null){
            num++;
            h = h.next;
        }
        int b = num / k;
        int c = num % k;
        h = head;
        int i = 0;
        while (i < k){
            int t = b;
            if (c-- > 0)    t += 1;
            ListNode a = h;
            while (h!=null && t-- > 1){
                h = h.next;
            }
            r[i] = a;
            if (h != null) {
                ListNode x = h;
                h = h.next;
                x.next = null;
            }
            i++;
        }
        return r;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
