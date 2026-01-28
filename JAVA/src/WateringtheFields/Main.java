package WateringtheFields;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][2];
        List<int[]>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0]=x;
            arr[i][1]=y;
        }

        for(int i=0;i<N-1;i++){
            for(int j=i+1;j<N;j++){
                int val = (int)Math.pow(arr[i][0]-arr[j][0],2)+(int)Math.pow(arr[i][1]-arr[j][1],2);
                if(val>=C) {
                    graph[i].add(new int[]{j,val});
                    graph[j].add(new int[]{i,val});
                }
            }
        }

        bw.write(String.valueOf(prim(N,graph)));

        br.close();
        bw.close();
    }

    private static int prim(int N, List<int[]>[] graph){
        Queue<int[]> pq = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        pq.offer(new int[]{0,0});
        boolean[] flag = new boolean[N];
        int ans=0;
        int cnt=0;
        while(!pq.isEmpty()){
            int[] f = pq.poll();
            int fc=f[0], fi=f[1];
            if(flag[fi]) continue;
            flag[fi]=true;
            ans+=fc;
            cnt++;
            for(int[] node : graph[fi]) if(!flag[node[0]]) pq.offer(new int[]{node[1],node[0]});
        }

        if(cnt<N) return -1;
        return ans;
    }
}
