package 숨박꼭질3_2;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 100001;
    private static final int[] di={2,1,1}, dj={0,1,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] flag = new int[MAX];
        flag[N]=1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        while(!q.isEmpty()){
            int f=q.poll();
            if(f==K) break;
            for(int d=0;d<3;d++){
                int n=f*di[d]+dj[d];
                int nc=d==0?flag[f]:flag[f]+1;
                if(n<0||n>=MAX) continue;
                if(flag[n]>0 && flag[n]<=nc) continue;
                flag[n]=nc;
                q.offer(n);
            }
        }

        bw.write(String.valueOf(flag[K]-1));
        br.close();
        bw.close();
    }
}