package 회전초밥_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int len = N+k-1;

        int[] flag = new int[d+1];
        int[] arr = new int[len];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        for(int i=N;i<len;i++) arr[i]=arr[i-N];

        int ans=1;
        flag[c]=1;
        for(int i=0;i<k;i++){
            int num = arr[i];
            if(flag[num]==0) ans++;
            flag[num]++;
        }

        int tmp=ans;
        for(int i=k;i<len;i++){
            int bnum=arr[i-k];
            int num=arr[i];
            if(--flag[bnum]==0) tmp--;
            if(++flag[num]==1) tmp++;

            ans = Math.max(ans, tmp);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}