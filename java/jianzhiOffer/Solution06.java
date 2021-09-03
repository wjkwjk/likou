package jianzhiOffer;


public class Solution06 {

    public int[] reversePrint(ListNode head) {
        ListNode L = head;
        int n = 0;
        while (L!=null){
            n++;
            L = L.next;
        }

        int[] r = new int[n];
        L = head;
        while (L!=null){
            r[--n] = L.val;
            L = L.next;
        }
        return r;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
