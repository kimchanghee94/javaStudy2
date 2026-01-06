package 녹색옷입은애가젤다지;
import java.io.*;
import java.util.*;

public class Main {
    private static final int[] di = {1,0,-1,0};
    private static final int[] dj = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tCase=1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;

            int[][] graph = new int[N][N];
            for(int i=0;i<N;i++){
                 StringTokenizer st = new StringTokenizer(br.readLine());
                 for(int j=0;j<N;j++) graph[i][j]=Integer.parseInt(st.nextToken());
            }
            bw.write("Problem "+tCase+": "+dijkstra(N, graph)+"\n");
            tCase++;
        }

        br.close();
        bw.close();
    }

    private static int dijkstra(int N, int[][] graph){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] dist =  new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        pq.offer(new int[]{graph[0][0],0,0});
        dist[0][0]=graph[0][0];
        while(!pq.isEmpty()){
            int[] f = pq.poll();
            int fc = f[0], fi = f[1], fj = f[2];
            if(fc > dist[fi][fj]) continue;

            for(int d=0;d<4;d++){
                int ni=fi+di[d], nj=fj+dj[d];
                if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                int nc=fc+graph[ni][nj];
                if(dist[ni][nj]<=nc) continue;
                dist[ni][nj]=nc;
                pq.offer(new int[]{nc,ni,nj});
            }
        }
        return dist[N-1][N-1];
    }
}
