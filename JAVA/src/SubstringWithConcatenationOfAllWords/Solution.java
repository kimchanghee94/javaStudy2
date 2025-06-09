package SubstringWithConcatenationOfAllWords;

import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        Map<String, Integer> flag = new HashMap<>();
        Map<String, Integer> tmpFlag = new HashMap<>();

        int left = 0;
        int len = words[0].length();
        int totLen = words.length;

        for(int i=0; i<words.length; i++){
            flag.put(words[i], flag.getOrDefault(words[i], 0) + 1);
        }

        for(int i=0; i<s.length(); i++){
            if((i+1)%len == 0){
                String tmp = s.substring(left, i+1);

                if(flag.containsKey(tmp)){

                }
            }
        }

        return ans;
    }
}
