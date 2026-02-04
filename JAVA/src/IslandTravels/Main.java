package IslandTravels;
import java.io.*;
import java.util.*;

public class Main {
    private static int R,C,islandCnt,full;
    private static int[][] map;
    private static char[][] graph;
    private static int[][] dist;
    private static int[][] dp;
    private static final int[] di={1,0,-1,0}, dj={0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        map = new int[R][C];
        for(int i=0;i<R;i++) graph[i]=br.readLine().toCharArray();

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(graph[i][j]=='X' && map[i][j]==0) {
                    islandCnt++;
                    dfs(i,j);
                }
            }
        }

        dist = new int[islandCnt+1][islandCnt+1];
        for(int m=1;m<=islandCnt;m++){
            boolean once=false;
            for(int i=0;i<R && !once;i++){
                for(int j=0;j<C && !once;j++){
                    if(map[i][j]==m){
                        bfs(i,j,m);
                        once=true;
                    }
                }
            }
        }

        dp = new int[1<<islandCnt][islandCnt+1];
        full=(1<<islandCnt)-1;
        bw.write(String.valueOf(calc(0,0)));
        br.close();
        bw.close();
    }

    private static int calc(int visited, int fi){
        if(dp[visited][fi]!=0) return dp[visited][fi];
        if(visited==full) return dp[visited][fi]=0;
        int min=Integer.MAX_VALUE;
        for(int ni=1;ni<=islandCnt;ni++){
            if(fi==ni || (visited & (1<<(ni-1)))!=0) continue;
            min=Math.min(min,calc(visited | (1<<ni-1), ni)+dist[fi][ni]);
        }
        return dp[visited][fi]=min;
    }

    private static void bfs(int si, int sj, int m){
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,si,sj});
        boolean[][] flag = new boolean[R][C];
        flag[si][sj]=true;

        while(!pq.isEmpty()){
            int[] f = pq.poll();
            int fc=f[0], fi=f[1], fj=f[2];
            for(int d=0;d<4;d++){
                int ni=fi+di[d],nj=fj+dj[d];
                if(ni<0 || ni>=R || nj<0 || nj>=C || graph[ni][nj]=='.' || flag[ni][nj]) continue;
                flag[ni][nj]=true;
                if(graph[ni][nj]=='S') pq.offer(new int[]{fc+1,ni,nj});
                else{
                    int nm = map[ni][nj];
                    if(nm!=m) dist[m][nm]=fc;
                    pq.offer(new int[]{fc,ni,nj});
                }
            }
        }
    }

    private static void dfs(int fi, int fj){
        map[fi][fj]=islandCnt;
        for(int d=0;d<4;d++){
            int ni=fi+di[d], nj=fj+dj[d];
            if(ni<0 || ni>=R || nj<0 || nj>=C || graph[ni][nj]!='X' || map[ni][nj]!=0) continue;
            dfs(ni,nj);
        }
    }
}
