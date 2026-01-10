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
        int s=Integer.parseInt(st.nextToken());
        boolean chk=true;
        for(int i=1;i<M;i++){
            flag[s]=true;
            int e=Integer.parseInt(st.nextToken());
            if(!dfs(s,e)) {
                chk=false;
                break;
            }
            Arrays.fill(flag,false);
            s=e;
        }

        if(chk) bw.write("YES");
        else bw.write("NO");
        br.close();
        bw.close();
    }

    private static boolean dfs(int s, int e){
        if(s==e) return true;
        for(int i=1;i<=N;i++){
            if(graph[s][i]==0 || flag[i]) continue;
            flag[i]=true;
            if(dfs(i,e)) return true;
        }
        return false;
    }
}