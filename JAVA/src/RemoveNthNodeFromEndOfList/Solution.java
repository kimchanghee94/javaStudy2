package RemoveNthNodeFromEndOfList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = dummy;
        ListNode next = head;
        for(int i=0; i<n-1; i++) next = next.next;

        while(next != null){
            if(next.next == null) cur.next = cur.next.next;
            cur = cur.next;
            next = next.next;
        }

        return dummy.next;
    }
}