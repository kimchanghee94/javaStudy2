package 소가길을건너간이유6;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,K,R;
    private static final int[] di={1,0,-1,0}, dj={0,1,0,-1};
    private static boolean[][] flag, cow;
    private static boolean[][][][] road;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        flag = new boolean[N][N];
        cow = new boolean[N][N];
        road = new boolean[N][N][N][N];

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            int r2 = Integer.parseInt(st.nextToken())-1;
            int c2 = Integer.parseInt(st.nextToken())-1;
            road[r1][c1][r2][c2]=true;
            road[r2][c2][r1][c1]=true;
        }

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            cow[x][y]=true;
        }
        int ans=(K*(K-1))/2;
        for(int i=0;i<N;i++) for(int j=0;j<N;j++) if(!flag[i][j]) ans-=bfs(i,j);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static int bfs(int si, int sj){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{si,sj});

        int cnt=0;
        if(cow[si][sj]) cnt++;
        flag[si][sj]=true;

        while(!q.isEmpty()){
            int[] f = q.poll();
            int fi=f[0], fj=f[1];

            for(int d=0;d<4;d++){
                int ni=fi+di[d], nj=fj+dj[d];
                if(ni<0 || ni>=N || nj<0 || nj>=N || flag[ni][nj] || road[fi][fj][ni][nj]) continue;
                if(cow[ni][nj]) cnt++;
                flag[ni][nj]=true;
                q.offer(new int[]{ni,nj});
            }
        }
        cnt=(cnt*(cnt-1))/2;
        return cnt;
    }
}