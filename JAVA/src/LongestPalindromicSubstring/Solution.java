package LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        if(n==1) return s;
        boolean[][] dp=new boolean[n][n];
        int strt=0,mL=1;
        for(int i=0;i<n;i++) dp[i][i]=true;
        for(int l=2;l<=n;l++) for(int i=0;i<=n-l;i++){
            int j=i+l-1;
            if(s.charAt(i)==s.charAt(j)) if(l==2||dp[i+1][j-1]){
                dp[i][j]=true;
                if(l>mL){
                    strt=i;
                    mL=l;
                }
            }
        }
        return s.substring(strt, strt+mL);
    }
}