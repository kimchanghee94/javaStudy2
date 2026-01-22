package 횡단보도;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<int[]>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++) graph[i]=new ArrayList<>();
        for(int i=1;i<=M;i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken())-1;
            int B = Integer.parseInt(st.nextToken())-1;
            graph[A].add(new int[]{B,i});
            graph[B].add(new int[]{A,i});
        }

        bw.write(String.valueOf(dijkstra(N, M, graph)));

        br.close();
        bw.close();
    }
    private static long dijkstra(int N, int M, List<int[]>[] graph){
        long[] dist = new long[N];
        Arrays.fill(dist,Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        pq.offer(new long[]{0,0});
        dist[0]=0;

        while(!pq.isEmpty()){
            long[] f = pq.poll();
            long fc = f[0];
            int fi = (int)f[1];
            if(dist[fi]<fc) continue;

            for(int i=0;i<graph[fi].size();i++){
                int ni = graph[fi].get(i)[0];
                long nc = graph[fi].get(i)[1];
                if(nc<fc){
                    long cycle=(fc-nc)/M;
                    if((fc-nc)%M!=0) cycle++;
                    nc+=cycle*M;
                }
                if(nc>=dist[ni]) continue;
                dist[ni]=nc;
                pq.offer(new long[]{nc,ni});
            }
        }

        return dist[N-1];
    }
}