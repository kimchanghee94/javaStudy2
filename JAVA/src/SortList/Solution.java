package SortList;
import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode mid = getMiddle(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);

        return merge(leftSorted, rightSorted);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while(left != null && right != null){
            if(left.val <= right.val) {
                cur.next = left;
                left = left.next;
            }
            else if(left.val > right.val) {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }

        if(left != null) cur.next = left;
        if(right != null) cur.next = right;

        return dummy.next;
    }

    private ListNode getMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast != null && fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}