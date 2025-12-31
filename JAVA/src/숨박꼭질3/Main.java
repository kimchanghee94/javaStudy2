package 숨박꼭질3;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 100001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] flag = new int[MAX];
        Arrays.fill(flag, MAX);
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        flag[N]=1;
        while(!q.isEmpty()){
            int f = q.poll();
            for(int d=0;d<3;d++){
                int n=f;
                int dist=flag[f];
                if(d==0) n*=2;
                else if(d==1) {
                    n++;
                    dist++;
                }
                else {
                    n--;
                    dist++;
                }

                if(n<0 || n>=MAX || dist>=flag[n]) continue;
                q.offer(n);
                flag[n]=dist;
            }
        }

        bw.write(String.valueOf(flag[K]-1));
        br.close();
        bw.close();
    }
}
