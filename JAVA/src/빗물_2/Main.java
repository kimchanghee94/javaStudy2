package 빗물_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<W;i++) arr[i]=Integer.parseInt(st.nextToken());
        int l=0, r=W-1;
        int lH=arr[l], rH=arr[r];
        int ans=0;

        while(l<r){
            if(lH<rH){
                l++;
                ans+=(lH<=arr[l] ? 0 : lH-arr[l]);
                lH=Math.max(lH,arr[l]);
            }else{
                r--;
                ans+=(rH<=arr[r] ? 0 : rH-arr[r]);
                rH=Math.max(rH,arr[r]);
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}