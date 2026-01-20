package 로봇조종하기;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] dp = new int[2][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) arr[i][j]=Integer.parseInt(st.nextToken());
        }
        dp[0][0]=dp[1][0]=arr[0][0];
        for(int i=1;i<M;i++) dp[0][i]=dp[1][i]=dp[0][i-1]+arr[0][i];
        for(int i=1;i<N;i++){
            dp[0][0]+=arr[i][0];
            dp[1][M-1]+=arr[i][M-1];
            for(int j=1;j<M;j++){
                dp[0][j]=Math.max(dp[0][j],dp[0][j-1])+arr[i][j];
                dp[1][M-j-1]=Math.max(dp[1][M-j],dp[1][M-j-1])+arr[i][M-j-1];
            }
            for(int j=0;j<M;j++) dp[0][j]=dp[1][j]=Math.max(dp[0][j],dp[1][j]);
        }
        bw.write(String.valueOf(dp[0][M-1]));
        br.close();
        bw.close();
    }
}
