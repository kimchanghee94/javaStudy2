package 주식_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[N];
            for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());

            int max = arr[N-1];
            long ans=0;
            for(int i=N-1;i>=0;i--){
                if(max<arr[i]) max=arr[i];
                else ans+=(max-arr[i]);
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}