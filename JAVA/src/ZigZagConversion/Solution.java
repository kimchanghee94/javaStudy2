package ZigZagConversion;

public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder ans = new StringBuilder();

        if(numRows == 1 || s.length() == 1 || s.length() <= numRows){
            return s;
        }

        for(int i=0; i<numRows; i++){
            ans.append(s.charAt(i));

            int j=i;

            while(true){
                int tmp = (2*numRows - 2*(i+1));

                if(j + tmp >= s.length()) break;
                if(tmp != 0) ans.append(s.charAt(j + tmp));
                j += tmp;

                tmp = (2*numRows - 2*(numRows - i));
                if(j + tmp >= s.length()) break;
                if(tmp != 0) ans.append(s.charAt(j + tmp));
                j += tmp;
            }
        }

        return ans.toString();
    }
}

/*
class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        StringBuilder ans = new StringBuilder();
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0; i<numRows; i++) rows[i]=new StringBuilder();
        int cur=0;
        boolean dir=false;
        for(char c : s.toCharArray()){
            rows[cur].append(c);
            if(cur==0 || cur==numRows-1) dir=!dir;
            cur+=dir?1:-1;
        }
        for(StringBuilder sb : rows) ans.append(sb);
        return ans.toString();
    }
}
*/