package 숨박꼭질_2;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 100005;
    private static final int[] di={2,1,1}, dj={0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        bw.write(bfs(N,K));
        br.close();
        bw.close();
    }

    private static String bfs(int N, int K){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        int[] flag = new int[MAX];
        flag[N]=1;

        while(!q.isEmpty()){
            int f = q.poll();
            if(f==K) break;

            for(int d=0;d<3;d++){
                int n=f*di[d]+dj[d];
                if(n<0 || n>=MAX || flag[n]!=0) continue;
                flag[n]=flag[f]+1;
                q.offer(n);
            }
        }

        return String.valueOf(flag[K]-1);
    }
}