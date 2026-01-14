package 벽부수고이동하기;
import java.io.*;
import java.util.*;

public class Main {
    private static final int[] di={1,0,-1,0}, dj={0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        for(int i=0;i<N;i++) board[i]=br.readLine().toCharArray();
        bw.write(String.valueOf(bfs(board, N, M)));
        br.close();
        bw.close();
    }
    private static int bfs(char[][] board, int N, int M){
        Queue<int[]> q = new LinkedList<>();
        int[][][] flag = new int[2][N][M];
        flag[0][0][0]=1;
        q.offer(new int[]{0,0,0});

        while(!q.isEmpty()){
            int[] f = q.poll();
            int idx = f[0];
            int fi = f[1];
            int fj = f[2];
            if(fi==N-1 && fj==M-1) return flag[idx][N-1][M-1];
            
            for(int d=0;d<4;d++){
                int ni = fi+di[d];
                int nj = fj+dj[d];
                int nIdx = idx;
                if(ni<0 || ni>=N || nj<0 || nj>=M || flag[nIdx][ni][nj]!=0 || (nIdx==1 && board[ni][nj]=='1')) continue;
                if(board[ni][nj]=='1') nIdx=1;
                q.offer(new int[]{nIdx,ni,nj});
                flag[nIdx][ni][nj]=flag[idx][fi][fj]+1;
            }
        }
        return -1;
    }
}