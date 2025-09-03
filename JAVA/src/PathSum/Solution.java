package PathSum;

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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int sum){
        if(root == null) return false;
        sum+=root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum) return true;
            else return false;
        }
        return dfs(root.left, targetSum, sum) || dfs(root.right, targetSum, sum);
    }
}

/*
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode root, int cur, int target){
        if(root == null) return false;
        if(cur+root.val == target && root.left==null && root.right==null) return true;
        return dfs(root.left, cur+root.val, target) || dfs(root.right,cur+root.val, target);
    }
}
*/