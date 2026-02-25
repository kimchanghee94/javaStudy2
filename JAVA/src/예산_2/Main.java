package 예산_2;
import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static int N,M;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        int l=1, r=Integer.MIN_VALUE;
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            r = Math.max(r, arr[i]);
        }
        M = Integer.parseInt(br.readLine());
        int ans=0;
        while(l<=r){
            int m=(l+r)/2;
            if(chk(m)){
                l=m+1;
                ans=m;
            }else r=m-1;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static boolean chk(int m){
        int sum=0;
        for(int i=0;i<N;i++) sum+=Math.min(arr[i],m);
        return sum<=M;
    }
}
