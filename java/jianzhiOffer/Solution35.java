package jianzhiOffer;

import java.util.HashMap;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution35 {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node h = head;
        HashMap<Node, Node>dict = new HashMap<>();

        Node newhead = new Node(head.val);
        dict.put(head, newhead);
        Node r = newhead;
        head = head.next;
        while (head!=null){
            Node p = new Node(head.val);
            dict.put(head, p);
            r.next = p;
            r = p;
            head = head.next;
        }
        r.next = null;

        Node nh = newhead;
        while (h!=null && nh!=null){
            if (h.random!=null){
                nh.random = dict.get(h.random);
            }
            h = h.next;
            nh = nh.next;
        }
        return newhead;

    }



}
