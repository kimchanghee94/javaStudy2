package 스위치켜고끄기_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i]=Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(s==1){
                int idx=1;
                while(n*idx<=N){
                    arr[n*idx]=arr[n*idx]==0?1:0;
                    idx++;
                }
            }else{
                int idx=1;
                arr[n]=arr[n]==0?1:0;
                while(n-idx>0 && n+idx<=N && arr[n-idx]==arr[n+idx]){
                    arr[n-idx]=arr[n+idx]=arr[n-idx]==0?1:0;
                    idx++;
                }
            }
        }
        for(int i=1;i<=N;i++) {
            bw.write(arr[i]+" ");
            if(i%20==0) bw.newLine();
        }
        br.close();
        bw.close();
    }
}