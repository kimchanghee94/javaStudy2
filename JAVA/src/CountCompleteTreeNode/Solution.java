package CountCompleteTreeNode;

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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int lH = getH(root.left);
        int rH = getH(root.right);
        if(lH == rH) return (1 << lH) + countNodes(root.right);
        else return (1 << rH) + countNodes(root.left);
    }
    private int getH(TreeNode root){
        int height = 0;
        while(root != null){
            height++;
            root = root.left;
        }
        return height;
    }
}

/*
class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int lH=getH(root.left);
        int rH=getH(root.right);
        if(lH==rH) return (1<<lH)+countNodes(root.right);
        else return (1<<rH)+countNodes(root.left);
    }
    private int getH(TreeNode root){
        int h=0;
        while(root != null){
            root=root.left;
            h++;
        }
        return h;
    }
}
*/