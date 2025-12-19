package 올림픽;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())-1;
        int[][] rank = new int[N][3];
        int ans=1;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken())-1;
            rank[k][0] = Integer.parseInt(st.nextToken());
            rank[k][1] = Integer.parseInt(st.nextToken());
            rank[k][2] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            if(rank[i][0]>rank[K][0]) ans++;
            else if(rank[i][0]==rank[K][0]){
                if(rank[i][1]>rank[K][1]) ans++;
                else if(rank[i][1]==rank[K][1]){
                    if(rank[i][2]>rank[K][2]) ans++;
                }
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}