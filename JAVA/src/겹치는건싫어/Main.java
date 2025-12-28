package 겹치는건싫어;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[200001];
        int[] flag = new int[100001];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        int l=0, ans=0;
        for(int i=0;i<N;i++){
            int v = arr[i];
            flag[v]++;
            while(flag[v]==K+1){
                flag[arr[l]]--;
                l++;
            }
            ans = Math.max(ans, i-l+1);
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
