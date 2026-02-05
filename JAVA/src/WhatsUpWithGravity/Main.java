package WhatsUpWithGravity;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static int[] C = new int[2];
    private static char[][] graph;
    private static final int[] dir={1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        for(int i=0;i<N;i++) graph[i]=br.readLine().toCharArray();
        for(int i=0;i<N;i++) for(int j=0;j<M;j++) if(graph[i][j]=='C'){ C[0]=i; C[1]=j;}

        C[0]=move(C[0],C[1],0);

        if(C[0]==-1) bw.write("0");
        else if(C[0]==N) bw.write("-1");
        else bw.write(String.valueOf(bfs()));

        br.close();
        bw.close();
    }

    private static int bfs(){
        boolean[][][] flag = new boolean[2][N][M];
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,C[0],C[1]});
        while(!pq.isEmpty()){
            int[] f=pq.poll();
            int fi=f[1],fj=f[2],fc=f[0];

            for(int d=0;d<3;d++){
                int ni=fi,nj=fj,nc=fc;
                if(d==0){
                    nc++;
                    ni=move(ni,nj,nc);
                    if(ni==N) continue;
                    if(ni==-1) return nc;
                }else{
                    nj+=dir[d-1];
                    if(nj<0 || nj>=M || graph[ni][nj]=='#' || flag[nc%2][ni][nj]) continue;
                    if(graph[ni][nj]=='D') return nc;
                    ni=move(ni,nj,nc);
                    if(ni==N) continue;
                    if(ni==-1) return nc;
                }

                if(flag[nc%2][ni][nj]) continue;
                flag[nc%2][ni][nj]=true;
                pq.offer(new int[]{nc,ni,nj});
            }
        }
        return -1;
    }

    private static int move(int i, int j, int d){
        while(i>=0 && i<N && (graph[i][j]=='.' || graph[i][j]=='C')) i+=dir[d%2];
        if(i==-1 || i==N) return N;
        else if(graph[i][j]=='D') return -1;
        else {
            i-=dir[d%2];
            return i;
        }
    }
}