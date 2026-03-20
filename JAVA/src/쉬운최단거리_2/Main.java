package 쉬운최단거리_2;
import java.io.*;
import java.util.*;

public class Main {
    private static int n,m;
    private static int[][] graph, ans;
    private static int[] di={1,0,-1,0}, dj={0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        ans = new int[n][m];
        int si=0,sj=0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j]==2){
                    si=i;
                    sj=j;
                }
            }
        }
        bfs(si,sj);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) bw.write(ans[i][j]+" ");
            bw.newLine();
        }
        br.close();
        bw.close();
    }

    private static void bfs(int si, int sj){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{si,sj});
        ans[si][sj]=1;

        while(!q.isEmpty()){
            int[] f = q.poll();
            int fi = f[0], fj=f[1];

            for(int d=0;d<4;d++){
                int ni=fi+di[d], nj=fj+dj[d];
                if(ni<0 || nj<0 || ni>=n || nj>=m || graph[ni][nj]==0 || ans[ni][nj]!=0) continue;
                ans[ni][nj]=ans[fi][fj]+1;
                q.offer(new int[]{ni,nj});
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(ans[i][j]>0) ans[i][j]--;
                else if(ans[i][j]==0 && graph[i][j]==1) ans[i][j]=-1;
            }
        }
    }
}