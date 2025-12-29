package 지름길;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][3];
        int[] dp = new int[D+1];
        Arrays.fill(dp, 10001);
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j]=Integer.parseInt(st.nextToken());
        }

        dp[0]=0;
        for(int i=0;i<D;i++){
            dp[i+1]=Math.min(dp[i+1],dp[i]+1);
            for(int j=0;j<N;j++){
                if(arr[j][0]==i && arr[j][1]<=D) dp[arr[j][1]]=Math.min(dp[arr[j][1]], dp[i]+arr[j][2]);
            }
        }
        bw.write(String.valueOf(dp[D]));
        br.close();
        bw.close();
    }
}
