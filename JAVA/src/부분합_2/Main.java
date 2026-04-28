package 부분합_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int l=0, sum=0, ans=Integer.MAX_VALUE;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=arr[i];
            while(sum>=S){
                ans=Math.min(ans, i-l+1);
                sum-=arr[l++];
            }
        }

        bw.write(ans==Integer.MAX_VALUE ? "0" : String.valueOf(ans));
        br.close();
        bw.close();
    }
}