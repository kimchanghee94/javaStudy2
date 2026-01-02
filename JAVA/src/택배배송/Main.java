package 택배배송;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] board = new ArrayList[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=1;i<=N;i++) board[i] = new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            board[A].add(new int[]{B,C});
            board[B].add(new int[]{A,C});
        }

        dijkstra(N,M,board,dist);
        bw.write(String.valueOf(dist[N]));
        br.close();
        bw.close();
    }

    private static void dijkstra(int N, int M, List<int[]>[] board, int[] dist){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,1});
        dist[1]=0;
        while(!pq.isEmpty()){
            int[] f = pq.poll();
            int fi = f[1];
            int fc = f[0];
            if(dist[fi]<fc) continue;
            for(int i=0;i<board[fi].size();i++){
                int ni=board[fi].get(i)[0];
                int nc=fc+board[fi].get(i)[1];
                if(nc>=dist[ni]) continue;
                dist[ni]=nc;
                pq.offer(new int[]{nc,ni});
            }
        }
    }
}
