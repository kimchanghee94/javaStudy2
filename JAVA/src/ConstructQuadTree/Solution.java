package ConstructQuadTree;

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;


    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}

public class Solution {
    public Node construct(int[][] grid) {
        int N=grid.length;
        return dfs(grid, 0, 0, N);
    }
    private Node dfs(int[][] grid, int si, int sj, int n){
        if(chk(grid, si, sj, n)) return new Node(grid[si][sj]==1, true);
        Node tl=dfs(grid,si,sj,n/2);
        Node tr=dfs(grid,si,sj+n/2,n/2);
        Node bl=dfs(grid,si+n/2,sj,n/2);
        Node br=dfs(grid,si+n/2,sj+n/2,n/2);
        return new Node(true,false,tl,tr,bl,br);
    }
    private boolean chk(int[][] grid, int si, int sj, int n){
        for(int i=si; i<n+si; i++) for(int j=sj; j<n+sj; j++)
            if(grid[i][j] != grid[si][sj]) return false;
        return true;
    }
}