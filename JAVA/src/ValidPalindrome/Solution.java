package ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        boolean ans = true;
        char[] filter = new char[s.length()];

        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            char tmp = s.charAt(i);

            if('a' <= tmp && tmp <= 'z' || '0' <= tmp && tmp <= '9'){
                filter[cnt++] = tmp;
            }else if('A' <= tmp && tmp <= 'Z'){
                filter[cnt++]  = (char)(tmp + 32);
            }
        }

        for(int i=0; i<cnt/2; i++){
            if(filter[i] != filter[cnt-i-1]){
                ans = false;
                break;
            }
        }

        return ans;
    }
}

/*
class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int l=0,r=s.length()-1;
        while(l<r){
            if(!Character.isLetterOrDigit(s.charAt(l))) l++;
            else if(!Character.isLetterOrDigit(s.charAt(r))) r--;
            else if(s.charAt(l) != s.charAt(r)) return false;
            else {
                l++;
                r--;
            }
        }
        return true;
    }
}
*/