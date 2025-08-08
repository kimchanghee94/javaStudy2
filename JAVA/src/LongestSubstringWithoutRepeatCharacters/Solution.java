package LongestSubstringWithoutRepeatCharacters;

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

/*
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] flag = new boolean[128];
        int ans=0, l=0;
        for(int i=0; i<s.length(); i++){
            while(flag[s.charAt(i)]) flag[s.charAt(l++)] = false;
            ans=Math.max(ans, i-l+1);
            flag[s.charAt(i)]=true;
        }
        return ans;
    }
}
*/