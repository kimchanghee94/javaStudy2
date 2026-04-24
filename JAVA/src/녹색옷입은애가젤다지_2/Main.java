package 녹색옷입은애가젤다지_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] di={1,0,-1,0}, dj={0,1,0,-1};

        int T=1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N==0) break;
            int[][] arr = new int[N][N];
            int[][] dist = new int[N][N];
            for(int i=0;i<N;i++){
                Arrays.fill(dist[i],Integer.MAX_VALUE);
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) arr[i][j]=Integer.parseInt(st.nextToken());
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
            pq.offer(new int[]{arr[0][0],0,0});
            dist[0][0]=arr[0][0];

            while(!pq.isEmpty()){
                int[] f = pq.poll();
                int fc = f[0], fi=f[1], fj=f[2];
                if(fc>dist[fi][fj]) continue;

                for(int d=0;d<4;d++){
                    int ni=fi+di[d], nj=fj+dj[d];
                    if(ni<0 || ni>=N || nj<0 || nj>=N) continue;
                    int nc=fc+arr[ni][nj];
                    if(dist[ni][nj]<=nc) continue;
                    pq.offer(new int[]{nc,ni,nj});
                    dist[ni][nj]=nc;
                }
            }

            bw.write("Problem " + T + ": " + dist[N-1][N-1]+"\n");
            T++;
        }

        br.close();
        bw.close();
    }
}