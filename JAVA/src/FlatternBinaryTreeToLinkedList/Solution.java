package FlatternBinaryTreeToLinkedList;

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
    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while(cur != null){
            if(cur.left != null){
                TreeNode rMost = cur.left;
                while(rMost.right != null) rMost = rMost.right;
                rMost.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}

/*
class Solution {
    public void flatten(TreeNode root) {
        while(root!=null){
            if(root.left!=null){
                TreeNode right = root.left;
                while(right.right != null) right=right.right;
                right.right = root.right;
                root.right = root.left;
                root.left=null;
            }
            root=root.right;
        }
    }
}
*/