package GroupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String w : strs){
            char[] c = w.toCharArray();
            Arrays.sort(c);
            String key = new String(c);
            map.computeIfAbsent(key, k->new ArrayList<>()).add(w);
        }
        return new ArrayList<>(map.values());
    }
}