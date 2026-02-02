package 인터넷설치;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,P,K;
    private static List<int[]>[] graph;
    private static final int MAX = 1000001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<P;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,v});
            graph[e].add(new int[]{s,v});
        }

        int l=0, r=MAX, ans=-1;
        while(l<r){
            int mid = (l+r)/2;
            if(dijkstra(mid)) ans=r=mid;
            else l=mid+1;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
    private static boolean dijkstra(int price){
        int[] count = new int[N+1];
        Arrays.fill(count, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,1});

        while(!pq.isEmpty()){
            int[] f = pq.poll();
            int fc = f[0];
            int fi = f[1];
            if(count[fi]<=fc) continue;
            count[fi]=fc;

            for(int i=0;i<graph[fi].size();i++){
                int ni = graph[fi].get(i)[0];
                int np = graph[fi].get(i)[1];

                if(np<=price && count[ni]>fc) pq.offer(new int[]{fc,ni});
                else if(np>price && count[ni]>fc+1) pq.offer(new int[]{fc+1,ni});
            }
        }

        if(count[N]>K) return false;
        return true;
    }
}