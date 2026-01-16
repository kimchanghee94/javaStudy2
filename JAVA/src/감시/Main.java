package 감시;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,M,C,ans=Integer.MAX_VALUE;
    private static int[][] graph, cctv;
    private static final int[] rCnt = {4,2,4,4,1};
    private static final int[] dCnt = {1,2,2,3,4};
    private static final int[][][][] dir = {
            {{{1,0}},{{-1,0}},{{0,1}},{{0,-1}}},
            {{{1,0},{-1,0}},{{0,1},{0,-1}}},
            {{{-1,0},{0,1}},{{0,1},{1,0}},{{1,0},{0,-1}},{{0,-1},{-1,0}}},
            {{{-1,0},{0,1},{0,-1}},{{-1,0},{0,1},{1,0}},{{0,-1},{0,1},{1,0}},{{-1,0},{0,-1},{1,0}}},
            {{{1,0},{0,1},{-1,0},{0,-1}}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        cctv = new int[8][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                graph[i][j] = val;
                if (1 <= val && val <= 5) {
                    cctv[C][0] = i;
                    cctv[C][1] = j;
                    C++;
                }
            }
        }
        backtrack(0);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void backtrack(int cnt){
        if(cnt==C){
            int tmp=0;
            for(int i=0;i<N;i++) for(int j=0;j<M;j++) if(graph[i][j]==0) tmp++;
            ans=Math.min(ans,tmp);
            return;
        }

        int[][] tmpGraph = new int[N][M];
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) tmpGraph[i][j]=graph[i][j];

        int ci=cctv[cnt][0];
        int cj=cctv[cnt][1];
        int cn=graph[ci][cj]-1;

        for(int r=0;r<rCnt[cn];r++){
            for(int d=0;d<dCnt[cn];d++){
                int fi=ci+dir[cn][r][d][0];
                int fj=cj+dir[cn][r][d][1];

                while(fi>=0 && fi<N && fj>=0 && fj<M && graph[fi][fj]!=6){
                    if(graph[fi][fj]==0) graph[fi][fj]=9;
                    fi+=dir[cn][r][d][0];
                    fj+=dir[cn][r][d][1];
                }
            }
            backtrack(cnt+1);
            for(int i=0;i<N;i++) for(int j=0;j<M;j++) graph[i][j]=tmpGraph[i][j];
        }
    }
}