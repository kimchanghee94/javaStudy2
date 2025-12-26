package 주식;
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
            long[] arr = new long[N];
            for(int i=0;i<N;i++) arr[i]=Long.parseLong(st.nextToken());

            long ans=0, last=arr[N-1];
            for(int i=N-2;i>=0;i--){
                if(last<=arr[i]) last=arr[i];
                else ans+=(last-arr[i]);
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}
