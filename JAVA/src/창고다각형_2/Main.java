package 창고다각형_2;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 1001;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int l=MAX, r=0;
        int[] arr = new int[MAX];
        while(N-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x]=y;
            l=Math.min(l,x);
            r=Math.max(r,x);
        }

        int lH=arr[l], rH=arr[r];
        int ans=0;
        while(l<=r){
            if(lH<=rH){
                ans+=lH;
                lH=Math.max(lH,arr[++l]);
            }else{
                ans+=rH;
                rH=Math.max(rH,arr[--r]);
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}