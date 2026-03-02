package 진우의달여행Small_2;
import java.io.*;
import java.util.*;

public class Main {
    private static int N,M;
    private static int[][] arr;
    private static int ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) arr[i][j]=Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<M;i++) backtrack(0,i,-2,arr[0][i]);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void backtrack(int i, int j, int dir, int sum){
        if(i==N-1) ans=Math.min(ans,sum);
        else{
            for(int d=-1;d<=1;d++){
                if(d==dir || j+d<0 || j+d>=M) continue;
                backtrack(i+1,d+j,d,sum+arr[i+1][d+j]);
            }
        }
    }
}