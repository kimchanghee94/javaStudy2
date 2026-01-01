package 뱀과사다리게임;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX=101;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[MAX];
        int[] flag = new int[MAX];
        for(int i=0;i<N+K;i++){
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        while(!q.isEmpty()){
            int f=q.poll();
            for(int i=1;i<=6;i++){
                int n=f+i;
                if(n>=MAX || flag[n]!=0) continue;
                flag[n]=flag[f]+1;
                if(arr[n]!=0 && flag[arr[n]]==0){
                    flag[arr[n]]=flag[n];
                    q.offer(arr[n]);
                }else if(arr[n]==0) q.offer(n);
            }
        }

        bw.write(String.valueOf(flag[MAX-1]));
        br.close();
        bw.close();
    }
}