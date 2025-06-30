package RotateList;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k==0) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = head;
        int len=1;
        while(tail.next != null){
            tail = tail.next;
            len++;
        }

        k%=len;
        ListNode strt = head;
        for(int i=0; i<len-k-1; i++) strt = strt.next;

        tail.next = dummy.next;
        dummy.next = strt.next;
        strt.next = null;

        return dummy.next;
    }
}