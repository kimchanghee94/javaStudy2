package 미네랄2;
import java.io.*;
import java.util.*;

public class Main {
    private static int R,C;
    private static char[][] graph;
    private static int[][] flag;
    private static final int[] di={1,0,-1,0}, dj={0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        graph = new char[R][C];
        flag = new int[R][C];
        for(int i=0;i<R;i++) graph[i]=br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int n=0;n<N;n++){
            int H = R-Integer.parseInt(st.nextToken());

            if(n%2==0){
                for(int i=0;i<C;i++) {
                    if(graph[H][i]=='x'){
                        graph[H][i]='.';
                        break;
                    }
                }
            }else{
                for(int i=C-1;i>=0;i--) {
                    if(graph[H][i]=='x'){
                        graph[H][i]='.';
                        break;
                    }
                }
            }

            int sep=1;
            for(int i=0;i<R;i++) Arrays.fill(flag[i],0);
            for(int i=R-1;i>=0;i--) {
                for(int j=0;j<C;j++) {
                    if(flag[i][j]==0 && graph[i][j]=='x') {
                        if(i==R-1) dfs(i,j,1);
                        else dfs(i,j,++sep);
                    }
                }
            }

            if(sep==2){
                int drop=R;
                for(int i=0;i<R;i++){
                    for(int j=0;j<C;j++){
                        if(flag[i][j]!=2) continue;
                        int d=i;
                        while(d<R && flag[d][j]!=1) d++;
                        drop = Math.min(drop, d-i-1);
                    }
                }
                for(int i=0;i<C;i++){
                    for(int j=R-1;j>=0;j--){
                        if(flag[j][i]!=2) continue;
                        graph[j][i]='.';
                        graph[j+drop][i]='x';
                    }
                }
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++) bw.write(graph[i][j]);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private static void dfs(int fi, int fj, int sep){
        flag[fi][fj]=sep;
        for(int d=0;d<4;d++){
            int ni=fi+di[d], nj=fj+dj[d];
            if(ni<0 || ni>=R || nj<0 || nj>=C || graph[ni][nj]!='x' || flag[ni][nj]!=0) continue;
            dfs(ni,nj,sep);
        }
    }
}