package 쉬운최단거리;
import java.io.*;
import java.util.*;

public class Main {
    private static int n,m;
    private static int[][] graph;
    private static int[] di = {1,0,-1,0};
    private static int[] dj = {0,1,0,-1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        int si=0,sj=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==2){
                    si=i;sj=j;
                }else if(graph[i][j]==1) graph[i][j]=-1;
            }
        }
        bfs(si,sj);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) bw.write(graph[i][j]+" ");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void bfs(int si, int sj){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{si,sj});
        graph[si][sj]=0;

        while(!q.isEmpty()){
            int[] f = q.poll();
            for(int d=0;d<4;d++){
                int ni = f[0]+di[d], nj = f[1]+dj[d];
                if(ni<0 || ni>=n || nj<0 || nj>=m || graph[ni][nj]!=-1) continue;
                q.offer(new int[]{ni,nj});
                graph[ni][nj]=graph[f[0]][f[1]]+1;
            }
        }
    }
}
