package 성냥개비;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX=101;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[MAX];
        Arrays.fill(dp,888_8888_8888_8888L);
        dp[2]=1;dp[3]=7;dp[4]=4;dp[5]=2;dp[6]=6;dp[7]=8;
        for(int i=8;i<MAX;i++) for(int j=2;j<8;j++) dp[i]=Math.min(dp[i], dp[i-j]*10 + (j==6 ? 0 : dp[j]));

        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n]+" ");
            if(n%2!=0) {
                bw.write("7");
                n-=3;
            }
            for(int i=0;i<n/2;i++) bw.write("1");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}