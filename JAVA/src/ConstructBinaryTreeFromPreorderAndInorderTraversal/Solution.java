package ConstructBinaryTreeFromPreorderAndInorderTraversal;

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
    int preIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return dfs(preorder, 0, inorder.length-1);
    }

    private TreeNode dfs(int[] pre, int left, int right){
        if(left > right) return null;

        int rootVal = pre[preIdx++];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.left = dfs(pre, left, rootIdx-1);
        root.right = dfs(pre, rootIdx+1, right);

        return root;
    }
}

/*
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int idx=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return dfs(preorder, 0, preorder.length-1);
    }

    private TreeNode dfs(int[] pre, int left, int right){
        if(left > right) return null;
        int val = pre[idx++], iIdx=map.get(val);
        return new TreeNode(val, dfs(pre, left, iIdx-1), dfs(pre, iIdx+1, right));
    }
}
*/