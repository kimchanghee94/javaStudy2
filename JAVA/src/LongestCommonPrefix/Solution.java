package LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder(strs[0]);

        for(int i=1; i<strs.length; i++){
            String val = strs[i];
            int preLen = prefix.length();

            if(preLen == 0){
                break;
            }

            if(!val.startsWith(prefix.toString())){
                prefix.deleteCharAt(preLen-1);
                i--;
            }
        }

        return prefix.toString();
    }
}

/*
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder ans = new StringBuilder(strs[0]);
        for(int i=1; i<strs.length; i++){
            while(!strs[i].startsWith(ans.toString())){
                ans.deleteCharAt(ans.length()-1);
                if(ans.length()==0) return "";
            }
        }
        return ans.toString();
    }
}
*/