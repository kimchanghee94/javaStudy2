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

/*
class Solution {
    public int lengthOfLastWord(String s) {
        int ans=0;
        int i=s.length()-1;
        while(i>=0 && s.charAt(i) == ' ') i--;
        while(i>=0 && s.charAt(i--) != ' ') ans++;
        return ans;
    }
}
*/