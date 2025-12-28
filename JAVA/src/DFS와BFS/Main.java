package DFS와BFS;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int N,M;
    private static int[][] graph;
    private static boolean[] flag;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        flag = new boolean[N+1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e]=1;
            graph[e][s]=1;
        }

        dfs(V);
        bw.newLine();
        Arrays.fill(flag,false);
        bfs(V);

        br.close();
        bw.close();
    }

    private static void dfs(int s) throws IOException{
        flag[s]=true;
        bw.write(s+" ");
        for(int i=1;i<=N;i++){
            if(graph[s][i]==1 && !flag[i]) dfs(i);
        }
    }

    private static void bfs(int s) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        flag[s]=true;

        while(!q.isEmpty()){
            int f = q.poll();
            bw.write(f+" ");
            for(int i=1;i<=N;i++){
                if(graph[f][i]==1 && !flag[i]){
                    flag[i]=true;
                    q.offer(i);
                }
            }
        }
    }
}
