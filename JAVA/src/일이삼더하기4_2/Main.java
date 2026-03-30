package 일이삼더하기4_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n+3][3];
            dp[1][0]=1;dp[2][0]=1;dp[2][1]=1;dp[3][0]=1;dp[3][1]=1;dp[3][2]=1;

            for(int i=4;i<=n;i++){
                dp[i][0]=dp[i-1][0];
                dp[i][1]=dp[i-2][0]+dp[i-2][1];
                dp[i][2]=dp[i-3][0]+dp[i-3][1]+dp[i-3][2];
            }

            bw.write(dp[n][0]+dp[n][1]+dp[n][2]+"\n");
        }

        br.close();
        bw.close();
    }
}