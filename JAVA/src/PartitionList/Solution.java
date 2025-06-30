package PartitionList;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;

        ListNode dummy = new ListNode(-201);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode cur = dummy;
        while(cur != null && cur.next != null){
            if(cur.val >= x && cur.next.val < x){
                ListNode next = cur.next;

                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;

                prev = prev.next;
            }else if(cur.val < x && cur.next.val < x) {
                prev = prev.next;
                cur = cur.next;
            }else cur = cur.next;
        }

        return dummy.next;
    }
}