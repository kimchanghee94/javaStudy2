package ConstructBinaryTreeFromInorderAndPostTraversal;

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
    Map<Integer, Integer> map = new HashMap<>();
    int postIdx = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        postIdx = postorder.length-1;
        return dfs(postorder, 0, postorder.length-1);
    }

    private TreeNode dfs(int[] post, int left, int right){
        if(left > right) return null;
        int rootVal = post[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right = dfs(post, rootIdx+1, right);
        root.left = dfs(post, left, rootIdx-1);
        return root;
    }
}