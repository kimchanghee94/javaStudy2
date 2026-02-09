package 돌게임_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[2]=1; dp[4]=1;
        for(int i=5;i<=N;i++) dp[i] = (dp[i-4]==1 || dp[i-1]==0) ? 1 : 0;
        bw.write(dp[N]==1 ? "CY" : "SK");
        br.close();
        bw.close();
    }
}