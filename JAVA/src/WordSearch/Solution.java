package WordSearch;

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    TrieNode(){
        children = new TrieNode[128];
        isWord = false;
    }
}

public class Solution {
    int N,M;
    int[] di = {1,0,-1,0}, dj = {0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        TrieNode root = buildTrie(word);
        N=board.length; M=board[0].length;
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) if(dfs(board, root, i, j)) return true;
        return false;
    }

    private boolean dfs(char[][] board, TrieNode root, int fi, int fj){
        if(fi<0||fi>N-1||fj<0||fj>M-1||board[fi][fj]=='#') return false;
        char c = board[fi][fj];
        TrieNode next = root.children[c];
        if(next == null) return false;
        if(next.isWord) return true;
        board[fi][fj]='#';
        for(int d=0; d<4; d++) if(dfs(board, next, fi+di[d], fj+dj[d])) return true;
        board[fi][fj]=c;
        return false;
    }

    private TrieNode buildTrie(String word){
        TrieNode root = new TrieNode();
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            if(cur.children[c] == null) cur.children[c] = new TrieNode();
            cur = cur.children[c];
        }
        cur.isWord = true;
        return root;
    }
}