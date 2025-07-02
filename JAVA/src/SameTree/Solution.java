package SameTree;

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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if((p==null && q!=null) || (p!=null && q==null)) return false;
        else if(p==null && q==null) return true;

        if(p.val != q.val) return false;
        boolean leftChk = isSameTree(p.left, q.left);
        boolean rightChk = isSameTree(p.right, q.right);
        if(!leftChk || !rightChk) return false;
        return true;
    }
}