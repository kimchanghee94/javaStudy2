package 인구이동;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,L,R;
    private static int sum,cnt;
    private static int[][] board;
    private static boolean[][] flag;
    private static final int[] di = {1,0,-1,0}, dj = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];
        flag = new boolean[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) board[i][j] = Integer.parseInt(st.nextToken());
        }
        int ans=0;
        while(true){
            boolean move = false;
            for(int i=0;i<N;i++) Arrays.fill(flag[i],false);
            for(int i=0;i<N;i++) for(int j=0;j<N;j++) if(!flag[i][j]) {
                flag[i][j]=true;
                sum=board[i][j];
                cnt=1;
                dfs(i,j);
                if(cnt>1){
                    board[i][j]=-1;
                    for(int a=0;a<N;a++) for(int b=0;b<N;b++) if(board[a][b]==-1) board[a][b]=sum/cnt;
                    move=true;
                }
            }
            if(!move) break;
            ans++;
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void dfs(int si, int sj){
        for(int d=0;d<4;d++){
            int ni=si+di[d];
            int nj=sj+dj[d];
            if(ni<0 || ni>=N || nj<0 || nj>=N || flag[ni][nj]
            || Math.abs(board[si][sj]-board[ni][nj])<L
            || Math.abs(board[si][sj]-board[ni][nj])>R) continue;
            flag[ni][nj]=true;
            sum+=board[ni][nj];
            cnt++;
            dfs(ni,nj);
            board[ni][nj]=-1;
        }
    }
}
