package WordPattern;

import java.util.*;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();

        String[] words = s.split(" ");

        if(words.length != pattern.length()) return false;

        for(int i=0; i<pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if(!pMap.containsKey(c)) pMap.put(c, word);
            else if(!pMap.get(c).equals(word)) return false;

            if(!sMap.containsKey(word)) sMap.put(word, c);
            else if(!sMap.get(word).equals(c)) return false;
        }

        return true;
    }
}

/*
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        if(pattern.length() != words.length) return false;
        Map<Character, String> map = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char c=pattern.charAt(i);
            String word=words[i];
            if(!map.containsKey(c)){
                if(map.containsValue(word)) return false;
                map.put(c, word);
            }else if(!map.get(c).equals(word)) return false;
        }
        return true;
    }
}
*/