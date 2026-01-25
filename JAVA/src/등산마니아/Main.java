package 등산마니아;
import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static long ans;
    private static List<Integer>[] graph;
    private static long[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        dp = new long[N+1];
        for(int i=1;i<=N;i++) graph[i]=new ArrayList<>();

        for(int i=0;i<N-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        dfs(1);
        bw.write(String.valueOf(ans-((long)N*(N-1)/2)));
        br.close();
        bw.close();
    }

    private static long dfs(int s){
        dp[s]=1;
        for(int e : graph[s]) if(dp[e]==0) dp[s]+=dfs(e);
        ans+=(((long)N*(N-1))/2) - (((N-dp[s])*(N-dp[s]-1))/2);
        return dp[s];
    }
}
