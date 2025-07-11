package WordSearch2;

import java.util.*;

class TrieNode{
    TrieNode[] children;
    String isWord;
    TrieNode(){
        children = new TrieNode[26];
        isWord = null;
    }
}

public class Solution {
    List<String> ans = new ArrayList<>();
    int N,M;
    int[] di = {1,0,-1,0};
    int[] dj = {0,1,0,-1};

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        N = board.length;
        M = board[0].length;
        for(int i=0; i<N; i++) for(int j=0; j<M; j++) dfs(board, i, j, root);
        return ans;
    }

    private void dfs(char[][] board, int fi, int fj, TrieNode root){
        if(fi<0||fi>N-1||fj<0||fj>M-1||board[fi][fj]=='#') return;
        char c = board[fi][fj];
        TrieNode next = root.children[c-'a'];
        if(next == null) return;
        if(next.isWord != null){
            ans.add(next.isWord);
            next.isWord = null;
        }
        board[fi][fj] = '#';
        for(int d=0; d<4; d++) dfs(board, fi+di[d], fj+dj[d], next);
        board[fi][fj] = c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for(String word : words){
            TrieNode cur = root;
            for(char c : word.toCharArray()){
                int idx = c-'a';
                if(cur.children[idx]==null) cur.children[idx]=new TrieNode();
                cur = cur.children[idx];
            }
            cur.isWord = word;
        }

        return root;
    }
}