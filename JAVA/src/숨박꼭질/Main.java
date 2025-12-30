package 숨박꼭질;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 100001;
    private static final int[] di = {1,1,2};
    private static final int[] dj = {1,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] flag = new int[MAX];
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        flag[N]=1;

        while(!q.isEmpty()){
            int f = q.poll();
            for(int d=0;d<3;d++){
                int n = f*di[d]+dj[d];
                if(n<0 || n>=MAX || flag[n]!=0) continue;
                flag[n]=flag[f]+1;
                q.offer(n);
            }
        }

        bw.write(String.valueOf(flag[K]-1));
        br.close();
        bw.close();
    }
}
