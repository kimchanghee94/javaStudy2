package 뱀과사다리게임_2;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX=101;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] board = new int[MAX];
        int[] flag = new int[MAX];
        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            board[x]=y;
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        flag[1]=1;

        while(!q.isEmpty()){
            int f=q.poll();
            if(f==MAX-1) break;

            for(int i=1;i<=6;i++){
                int n=f+i;
                if(n>=MAX || flag[n]>0) continue;
                flag[n]=flag[f]+1;

                if(board[n]!=0) {
                    n=board[n];
                    if(flag[n]>0) continue;
                    flag[n]=flag[f]+1;
                }
                q.offer(n);
            }
        }

        bw.write(String.valueOf(flag[MAX-1]-1));
        br.close();
        bw.close();
    }
}