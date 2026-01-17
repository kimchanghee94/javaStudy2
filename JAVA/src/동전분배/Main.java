package 동전분배;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t=0;t<3;t++){
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            int tot=0;
            for(int i=0;i<N;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
                tot += arr[i][0]*arr[i][1];
            }

            if(tot%2 != 0){
                bw.write("0\n");
                continue;
            }

            int[] dp = new int[50001];
            Arrays.fill(dp, -1);
            dp[0]=0;

            for(int i=0;i<N;i++){
                int price=arr[i][0];
                int cnt=arr[i][1];
                for(int j=0;j<=tot/2;j++){
                    if(dp[j]>=0) dp[j]=cnt;
                    else if(j>=price && dp[j-price]>0) dp[j]=dp[j-price]-1;
                }
            }
            bw.write((dp[tot/2]>=0 ? 1 : 0) + "\n");
        }

        br.close();
        bw.close();
    }
}
