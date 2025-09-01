package MaximumDepthOfBinaryTree;

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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        //DFS
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

        //BFS
        /*
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans=0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode tn = queue.poll();
                if(tn.left != null) queue.offer(tn.left);
                if(tn.right != null) queue.offer(tn.right);
            }
            ans++;
        }

        return ans;
        */
    }
}

/*
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int a = maxDepth(root.left);
        int b = maxDepth(root.right);
        return Math.max(a,b)+1;
    }
}
*/