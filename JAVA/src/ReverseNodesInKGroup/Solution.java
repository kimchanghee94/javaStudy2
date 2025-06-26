package ReverseNodesInKGroup;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            len++;
        }

        ListNode prev = dummy;
        cur=head;
        for(int i=0; i<len/k; i++){
            for(int j=0; j<k-1; j++){
                ListNode next = cur.next;
                cur.next = next.next;
                next.next = prev.next;
                prev.next = next;
            }
            prev = cur;
            cur = cur.next;
        }
        return dummy.next;
    }
}