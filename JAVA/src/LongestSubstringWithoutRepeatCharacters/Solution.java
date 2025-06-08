package LongestSubstringWithoutRepeatCharacters;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> flag = new HashSet<>();
        int left=0, ans=0;

        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);

            while(flag.contains(tmp)){
                flag.remove(s.charAt(left));
                left++;
            }

            flag.add(tmp);
            ans = Math.max(ans, i-left+1);
        }

        return ans;
    }
}
