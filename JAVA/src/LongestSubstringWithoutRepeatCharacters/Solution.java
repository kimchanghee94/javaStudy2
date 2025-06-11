package LongestSubstringWithoutRepeatCharacters;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] flag = new int[128];
        int left=0, ans=0;

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);

            while(flag[c] > 0){
                char dc = s.charAt(left);
                flag[dc]--;
                left++;
            }

            flag[c]++;
            ans = Math.max(ans, i-left+1);
        }

        return ans;
    }
}
