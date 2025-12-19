package 돌게임;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        int[] dp=new int[1001];
        dp[1]=1;dp[2]=0;dp[3]=1;
        for(int i=4;i<=N;i++) dp[i]=(dp[i-3]==1||dp[i-1]==1?0:1);
        bw.write(dp[N]==1 ? "SK":"CY");
        br.close();
        bw.close();
    }
}
