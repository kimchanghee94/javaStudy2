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
