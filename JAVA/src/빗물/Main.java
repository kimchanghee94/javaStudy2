package 빗물;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[W];
        for(int i=0;i<W;i++) arr[i]=Integer.parseInt(st.nextToken());
        int l=0, r=W-1;
        int maxL=0, maxR=0, ans=0;
        while(l<=r){
            if(arr[l]<=arr[r]){
                maxL=Math.max(maxL, arr[l]);
                ans+=maxL-arr[l];
                l++;
            }else{
                maxR=Math.max(maxR, arr[r]);
                ans+=maxR-arr[r];
                r--;
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
