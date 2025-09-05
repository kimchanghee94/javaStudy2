package MinimumAbsoluteDifferenceInBST;

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
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root){
        if(root==null) return;

        inorder(root.left);
        if(prev != null) ans = Math.min(Math.abs(prev.val-root.val), ans);
        prev = root;
        inorder(root.right);
    }
}

/*
class Solution {
    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root){
        if(root==null) return;
        dfs(root.left);
        if(prev!=null) ans=Math.min(ans, root.val-prev.val);
        prev=root;
        dfs(root.right);
    }
}
*/