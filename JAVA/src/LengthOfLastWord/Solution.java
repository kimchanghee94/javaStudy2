package LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int answer = 0;

        for(int i=len-1; i>=0; i--){
            if(s.charAt(i) == ' ' && answer != 0){
                break;
            }else if(s.charAt(i) != ' '){
                answer++;
            }
        }

        return answer;
    }
}
