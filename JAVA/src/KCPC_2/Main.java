package KCPC_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n+1][k+1];
            int[][] score = new int[n+1][3];

            for(int i=1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if(arr[a][b]<c) {
                    score[a][0]+=(c-arr[a][b]);
                    arr[a][b]=c;
                }
                score[a][1]++;
                score[a][2]=i;
            }

            int ans=1;
            for(int i=1;i<=n;i++){
                if(score[i][0]>score[t][0]) ans++;
                else if(score[i][0]==score[t][0]){
                    if(score[i][1]<score[t][1]) ans++;
                    else if(score[i][1]==score[t][1]){
                        if(score[i][2]<score[t][2]) ans++;
                    }
                }
            }

            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}