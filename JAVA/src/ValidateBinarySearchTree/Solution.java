package ValidateBinarySearchTree;

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
    TreeNode prev = null;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        boolean left = isValidBST(root.left);
        if(prev!=null&&prev.val>=root.val) return false;
        prev=root;
        boolean right = isValidBST(root.right);
        return left&&right;
    }
}