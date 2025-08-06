package RomanToInteger;

public class Solution {
    public int romanToInt(String s) {
        int answer = 0;

        for(int i=0; i<s.length(); i++){
            int first = val(s.charAt(i));
            int next = val(i != s.length() - 1 ? s.charAt(i+1) : '0');

            if(first < next){
                answer -= first;
            }else{
                answer += first;
            }
        }

        return answer;
    }

    private int val(char a) {
        return switch (a) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default  -> 0;
        };
    }
}

/*
class Solution {
    public int romanToInt(String s) {
        int ans=0;
        for(int i=0; i<s.length(); i++){
            int val=getVal(s.charAt(i));
            int nextVal=i==s.length()-1 ? 0 : getVal(s.charAt(i+1));
            if(val < nextVal) ans-=val;
            else ans+=val;
        }
        return ans;
    }

    private int getVal(char c){
        return switch(c){
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
*/