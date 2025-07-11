package WordLadder;

import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        for(String word : wordList) for(int i=0; i<word.length(); i++){
            String pattern = word.substring(0,i) + "*" + word.substring(i+1);
            graph.computeIfAbsent(pattern, k->new ArrayList<>()).add(word);
        }

        Queue<String> q = new LinkedList<>();
        Set<String> flag = new HashSet<>();
        q.offer(beginWord);
        flag.add(beginWord);
        int ans=1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String strt = q.poll();
                if(strt.equals(endWord)) return ans;
                for(int j=0; j<strt.length(); j++){
                    String pattern = strt.substring(0,j)+"*"+strt.substring(j+1);
                    List<String> neighbors = graph.getOrDefault(pattern, new ArrayList<>());
                    for(String neighbor : neighbors){
                        if(flag.contains(neighbor)) continue;
                        flag.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            ans++;
        }

        return 0;
    }
}