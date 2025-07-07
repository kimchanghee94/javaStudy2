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