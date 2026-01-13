package 파티;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N+1][N+1];
        int[][] xgraph = new int[N+1][N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[s][e]=c;
            xgraph[e][s]=c;
        }
        int[] dist1=dijkstra(graph,N,X);
        int[] dist2=dijkstra(xgraph,N,X);
        int ans=0;
        for(int i=1;i<=N;i++) ans=Math.max(ans,dist1[i]+dist2[i]);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static int[] dijkstra(int[][] graph, int N, int X){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.offer(new int[]{0,X});
        dist[X]=0;

        while(!pq.isEmpty()){
            int[] f=pq.poll();
            int fc=f[0], fi=f[1];
            if(fc>dist[fi]) continue;

            for(int ni=1;ni<=N;ni++){
                if(graph[fi][ni]==0) continue;
                int nc=fc+graph[fi][ni];
                if(nc>=dist[ni]) continue;
                dist[ni]=nc;
                pq.offer(new int[]{nc,ni});
            }
        }
        return dist;
    }
}
