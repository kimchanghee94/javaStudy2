package BinaryTreeMaximumPathSum;

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

class Solution {
    int answer = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return answer;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        int curMax = leftMax + rightMax + root.val;
        answer = Math.max(answer, curMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}

/*
class Solution {
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root){
        if(root==null) return 0;
        int lM=Math.max(dfs(root.left), 0);
        int rM=Math.max(dfs(root.right), 0);
        int cM=lM+rM+root.val;
        ans=Math.max(cM, ans);
        return Math.max(lM,rM)+root.val;
    }
}
*/