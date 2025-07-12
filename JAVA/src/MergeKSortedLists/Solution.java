package MergeKSortedLists;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return dfs(lists, 0, lists.length-1);
    }

    private ListNode dfs(ListNode[] lists, int left, int right){
        if(left == right) return lists[left];
        int mid = (left+right)/2;
        ListNode leftNode = dfs(lists, left, mid);
        ListNode rightNode = dfs(lists, mid+1, right);
        return merge(leftNode, rightNode);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(left!=null && right!=null){
            if(left.val <= right.val) {
                cur.next = left;
                left = left.next;
            }
            else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        cur.next = (left != null) ? left : right;
        return dummy.next;
    }
}