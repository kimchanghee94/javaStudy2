package MooTube;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        List<int[]>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            graph[p].add(new int[]{q,r});
            graph[q].add(new int[]{p,r});
        }

        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            bw.write(bfs(N, graph, k, v)+"\n");
        }

        br.close();
        bw.close();
    }

    private static int bfs(int N, List<int[]>[] graph, int k, int v){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        boolean[] flag = new boolean[N+1];
        flag[v]=true;
        int ans=0;
        while(!q.isEmpty()){
            int fi = q.poll();
            for(int i=0;i<graph[fi].size();i++){
                int ni=graph[fi].get(i)[0];
                int nc=graph[fi].get(i)[1];
                if(flag[ni] || nc<k) continue;
                ans++;
                flag[ni]=true;
                q.offer(ni);
            }
        }
        return ans;
    }
}