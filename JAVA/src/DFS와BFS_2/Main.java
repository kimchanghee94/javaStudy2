package DFS와BFS_2;
import java.io.*;
import java.util.*;

public class Main {
    private static boolean[] flag;
    private static List<Integer>[] graph;
    private static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        flag = new boolean[N+1];
        for(int i=0;i<N+1;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for(int i=1;i<=N;i++) graph[i].sort(Comparator.naturalOrder());
        dfs(V);
        for(int num : ans) bw.write(num + " ");
        Arrays.fill(flag, false);
        ans.clear();
        bw.newLine();

        bfs(V);
        for(int num : ans) bw.write(num + " ");
        br.close();
        bw.close();
    }

    private static void dfs(int s){
        flag[s]=true;
        ans.add(s);
        for(int i=0;i<graph[s].size();i++){
            int e = graph[s].get(i);
            if(flag[e]) continue;
            dfs(e);
        }
    }

    private static void bfs(int s){
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        flag[s]=true;
        ans.add(s);

        while(!q.isEmpty()){
            int f = q.poll();
            for(int i=0;i<graph[f].size();i++){
                int n = graph[f].get(i);
                if(flag[n]) continue;
                ans.add(n);
                flag[n]=true;
                q.offer(n);
            }
        }
    }
}