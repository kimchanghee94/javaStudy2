package KthSmallestElementInABST;

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
    int ans;
    int cnt;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(--cnt == 0) ans = root.val;
        inorder(root.right);
    }
}