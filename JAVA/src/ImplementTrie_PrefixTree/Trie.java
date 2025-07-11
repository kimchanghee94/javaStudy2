package ImplementTrie_PrefixTree;

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    public TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(cur.children[idx] == null) cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(cur.children[idx] == null) return false;
            cur = cur.children[idx];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()){
            int idx = c-'a';
            if(cur.children[idx] == null) return false;
            cur = cur.children[idx];
        }
        return true;
    }
}