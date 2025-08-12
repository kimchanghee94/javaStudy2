package ValidAnagram;

import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        /*if(s.length() != t.length()) return false;

        int[] hash = new int[26];
        for(char c : s.toCharArray()) hash[c-'a']++;
        for(char c : t.toCharArray()) if(--hash[c-'a'] < 0) return false;
        return true;*/

        int[] sa = s.codePoints().toArray();
        int[] ta = t.codePoints().toArray();
        if(sa.length != ta.length) return false;
        Map<Integer, Integer> hash = new HashMap<>();
        for(int c : sa) hash.put(c, hash.getOrDefault(c,0)+1);
        for(int c : ta) {
            hash.put(c, hash.getOrDefault(c,0)-1);
            if(hash.get(c)<0) return false;
        }
        return true;
    }
}

/*
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map=new int[26];
        for(char c : s.toCharArray()) map[c-'a']++;
        for(char c : t.toCharArray()) if((map[c-'a']--)==0) return false;
        return true;
    }
}
*/