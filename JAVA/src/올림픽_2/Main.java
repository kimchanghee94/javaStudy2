package 올림픽_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N+1][3];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            arr[T][0] = Integer.parseInt(st.nextToken());
            arr[T][1] = Integer.parseInt(st.nextToken());
            arr[T][2] = Integer.parseInt(st.nextToken());
        }

        int ans=1;
        for(int i=1;i<=N;i++){
            if(i==K) continue;
            if(arr[i][0]>arr[K][0]) ans++;
            else if(arr[i][0]==arr[K][0]){
                if(arr[i][1]>arr[K][1]) ans++;
                else if(arr[i][1]==arr[K][1]){
                    if(arr[i][2]>arr[K][2]) ans++;
                }
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}