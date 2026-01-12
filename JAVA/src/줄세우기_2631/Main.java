package 줄세우기_2631;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];
        int ans=0;
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        for(int i=1;i<N;i++) for(int j=0;j<i;j++) if(arr[j]<arr[i]){
            dp[i]=Math.max(dp[i],dp[j]+1);
            ans=Math.max(ans,dp[i]);
        }
        bw.write(String.valueOf(N-ans-1));
        br.close();
        bw.close();
    }
}