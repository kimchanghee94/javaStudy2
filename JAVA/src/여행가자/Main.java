package 여행가자;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static int[][] graph;
    private static boolean[] flag;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new int[N+1][N+1];
        flag = new boolean[N+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) graph[i][j]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        flag[s]=true;
        dfs(s);

        boolean chk = true;
        for(int i=1;i<M;i++){
            s = Integer.parseInt(st.nextToken());
            if(flag[s]==false){
                chk=false;
                break;
            }
        }
        bw.write(chk ? "YES" : "NO");
        br.close();
        bw.close();
    }

    private static void dfs(int s){
        for(int i=1;i<=N;i++){
            if(graph[s][i]==0 || flag[i]) continue;
            flag[i]=true;
            dfs(i);
        }
    }
}