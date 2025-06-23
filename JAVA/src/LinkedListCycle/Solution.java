package LinkedListCycle;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public boolean hasCycle(ListNode head) {
        // Set풀이 방식
        /*Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur != null){
            if(set.contains(cur)) return true;
            set.add(cur);
            cur = cur.next;
        }
        return false;*/

        //플로이드 사이클 탐지 방식
        if(head==null||head.next==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;

        while(slow!=fast){
            if(fast==null||fast.next==null) return false;
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
