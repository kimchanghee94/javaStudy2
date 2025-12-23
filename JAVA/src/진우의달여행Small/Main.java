package 진우의달여행Small;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,M,ans=1000;
    private static int[][] graph;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) graph[i][j] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++) backtrack(0,i,-2,graph[0][i]);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void backtrack(int fi, int fj, int dir, int sum){
        if(fi==N-1) ans = Math.min(ans,sum);
        else{
            for(int d=-1;d<=1;d++){
                int ni=fi+1, nj=fj+d;
                if(nj<0 || nj>=M || dir==d) continue;
                backtrack(ni,nj,d,sum+graph[ni][nj]);
            }
        }
    }
}