package ReverseWordsInAString;

public class Solution {
    public String reverseWords(String s) {
        String[] list = s.split(" +");
        StringBuilder ans = new StringBuilder();

        for(int i=list.length-1; i>=0; i--){
            ans.append(list[i]);
            ans.append(" ");
        }

        return ans.toString().trim();
    }
}
