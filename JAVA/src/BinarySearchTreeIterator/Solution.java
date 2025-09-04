package BinarySearchTreeIterator;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    private Stack<TreeNode> stack = new Stack<>();

    private void push(TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public Solution(TreeNode root) {
        push(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        push(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/*
class BSTIterator {
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
    }

    ListNode dummy, cur;

    public BSTIterator(TreeNode root) {
        dummy = new ListNode();
        cur = dummy;
        dfs(root);
        cur = dummy.next;
    }

    private void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        cur.next=new ListNode(root.val);
        cur=cur.next;
        dfs(root.right);
    }

    public int next() {
        int val = cur.val;
        cur=cur.next;
        return val;
    }

    public boolean hasNext() {
        if(cur==null) return false;
        else return true;
    }
}
*/