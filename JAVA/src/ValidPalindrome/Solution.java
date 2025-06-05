package ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        boolean ans = true;
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);

            if('a' <= tmp && tmp <= 'z' || '0' <= tmp && tmp <= '9'){
                sb.append(tmp);
            }
        }

        int len = sb.length();
        for(int i=0; i<len/2; i++){
            if(sb.charAt(i) != sb.charAt(len-i-1)){
                ans = false;
                break;
            }
        }

        return ans;
    }
}
