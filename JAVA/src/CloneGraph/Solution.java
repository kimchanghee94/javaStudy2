package CloneGraph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class Solution {
    Node[] flag = new Node[102];

    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return dfs(node);
    }

    private Node dfs(Node node){
        if(flag[node.val] != null) return flag[node.val];
        Node copy = new Node(node.val);
        flag[copy.val] = copy;
        for(Node neighbor : node.neighbors) copy.neighbors.add(dfs(neighbor));
        return copy;
    }
}

/*
class Solution {
    Node flag[] = new Node[105];
    public Node cloneGraph(Node node) {
        if(node==null) return node;
        if(flag[node.val]!=null) return flag[node.val];
        Node copy=new Node(node.val);
        flag[copy.val]=copy;
        for(Node neighbor : node.neighbors) copy.neighbors.add(cloneGraph(neighbor));
        return copy;
    }
}
*/