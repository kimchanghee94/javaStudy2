package DesignAddAndSearchWordsDataStructure;

class TrieNode{
    TrieNode[] children;
    boolean isWord;
    TrieNode(){
        children = new TrieNode[26];
        isWord = false;
    }
}

public class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(cur.children[idx] == null) cur.children[idx] = new TrieNode();
            cur = cur.children[idx];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int cnt, TrieNode node){
        if(word.length() == cnt) return node.isWord;

        char c = word.charAt(cnt);
        if(c == '.'){
            for(TrieNode next : node.children) if(next != null && dfs(word, cnt+1, next)) return true;
            return false;
        }else{
            TrieNode next = node.children[c-'a'];
            if(next == null) return false;
            return dfs(word, cnt+1, next);
        }
    }
}