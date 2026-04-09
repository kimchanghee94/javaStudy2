package 택배배송_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] graph = new ArrayList[N+1];
        for(int i=1;i<N+1;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph[A].add(new int[]{B,C});
            graph[B].add(new int[]{A,C});
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,1});
        dist[1]=0;
        while(!pq.isEmpty()){
            int[] f = pq.poll();
            int fi = f[1];
            int fc = f[0];

            if(dist[fi]<fc) continue;
            for(int i=0;i<graph[fi].size();i++){
                int ni = graph[fi].get(i)[0];
                int nc = fc+graph[fi].get(i)[1];
                if(nc>=dist[ni]) continue;
                dist[ni]=nc;
                pq.offer(new int[]{nc,ni});
            }
        }

        bw.write(String.valueOf(dist[N]));
        br.close();
        bw.close();
    }
}