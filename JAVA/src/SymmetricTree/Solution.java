package SymmetricTree;
import java.util.*;

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
    public boolean isSymmetric(TreeNode root) {
        //DFS
        return dfs(root, root);

        //BFS
        /*
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                arr.add(node.left==null ? null : node.left.val);
                arr.add(node.right==null ? null : node.right.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            for(int i=0; i<arr.size()/2; i++)
                if(arr.get(i) != arr.get(arr.size()-i-1)) return false;
        }

        return true;
        */
    }

    private boolean dfs(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        else if(left!=null && right!=null && left.val==right.val){
            return dfs(left.left, right.right) && dfs(left.right, right.left);
        }
        return false;
    }
}