package RemoveDuplicatesFromSortedList2;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;

        while(head != null){
            if(head.next != null && head.val == head.next.val){
                int val = head.val;
                while(head != null && head.val == val) head = head.next;
                cur.next = head;
            }else{
                cur = cur.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}