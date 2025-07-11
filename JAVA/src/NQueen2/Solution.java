package NQueen2;

public class Solution {
    int ans=0;
    boolean[] c,lc,rc;
    public int totalNQueens(int n) {
        c=new boolean[n];lc=new boolean[2*n];rc=new boolean[2*n];
        backtrack(n, 0);
        return ans;
    }

    private void backtrack(int n, int r){
        if(n == r) ans++;
        else{
            for(int i=0; i<n; i++){
                int li=r+i, ri=r-i+n-1;
                if(c[i]||lc[li]||rc[ri]) continue;
                c[i]=true;lc[li]=true;rc[ri]=true;
                backtrack(n, r+1);
                c[i]=false;lc[li]=false;rc[ri]=false;
            }
        }
    }
}