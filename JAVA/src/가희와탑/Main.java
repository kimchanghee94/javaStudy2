package 가희와탑;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[2*N];
        int idx=0;
        if(a<b) a--;
        else b--;
        for(int i=1;i<=a;i++) arr[idx++]=i;
        for(int i=b;i>=1;i--) arr[idx++]=i;
        if(idx>N) bw.write("-1");
        else{
            if(arr[0]==1) {
                for(int i=0;i<N-idx;i++) bw.write("1 ");
                for(int i=0;i<idx;i++) bw.write(arr[i]+" ");
            }else{
                bw.write(arr[0]+" ");
                for(int i=0;i<N-idx;i++) bw.write("1 ");
                for(int i=1;i<idx;i++) bw.write(arr[i]+" ");
            }
        }

        br.close();
        bw.close();
    }
}