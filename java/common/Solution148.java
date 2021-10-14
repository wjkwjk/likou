package common;

import java.util.*;

/**
 * 148. 排序链表
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 */
public class Solution148 {
    public ListNode sortList(ListNode head) {
        Map<Integer, List<ListNode>> listMap = new HashMap<>();
        ListNode h = head;
        while (h != null){
            if (!listMap.containsKey(h.val))    listMap.put(h.val, new ArrayList<>());
            listMap.get(h.val).add(h);
            h = h.next;
        }
        List<Integer> list = new ArrayList<>(listMap.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2)    return -1;
                else if (o1.equals(o2))  return 0;
                else return 1;
            }
        });
        h = new ListNode();
        head = h;
        for (Integer integer : list) {
            for (ListNode listNode : listMap.get(integer)) {
                h.next = listNode;
                h = h.next;
            }
        }
        h.next = null;
        return head.next;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
