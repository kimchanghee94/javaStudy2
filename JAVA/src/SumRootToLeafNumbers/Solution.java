package SumRootToLeafNumbers;

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
    int answer = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, "");
        return answer;
    }

    private void dfs(TreeNode root, String sum){
        if(root == null) return;

        sum+=root.val;
        if(root.left == null && root.right == null){
            answer += Integer.valueOf(sum.toString());
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}