package BinaryTreeZigZagLevelOrderTraversal;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }

            if(flag == true){
                Collections.reverse(tmp);
                flag = false;
            }else flag = true;
            ans.add(tmp);
        }
        return ans;
    }
}