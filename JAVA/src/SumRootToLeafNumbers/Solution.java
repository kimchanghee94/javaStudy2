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

/*
class Solution {
    int ans=0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum){
        if(root==null) return;
        int val = sum*10+root.val;
        if(root.left==null && root.right==null) ans+=val;
        dfs(root.left, val); dfs(root.right, val);
    }
}
*/