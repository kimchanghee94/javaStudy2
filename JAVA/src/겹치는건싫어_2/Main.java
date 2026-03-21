package 겹치는건싫어_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] flag = new int[100001];
        int l=0,ans=0;

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int n  = Integer.parseInt(st.nextToken());
            arr[i]=n;
            flag[n]++;
            while(flag[n]>K){
                flag[arr[l]]--;
                l++;
            }
            ans=Math.max(ans, i-l+1);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}