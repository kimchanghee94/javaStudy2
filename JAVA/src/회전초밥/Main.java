package 회전초밥;
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+k];
        int[] flag = new int[d+1];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        for(int i=N;i<N+k;i++) arr[i]=arr[i-N];
        int ans=0;
        for(int i=0;i<k;i++) if(flag[arr[i]]++==0) ans++;
        int tmpAns=ans;
        if(flag[c]==0) ans++;
        for(int i=k;i<N+k;i++){
            if(flag[arr[i-k]]--==1) tmpAns--;
            if(flag[arr[i]]++==0) tmpAns++;
            ans=Math.max(ans,flag[c]==0?tmpAns+1:tmpAns);
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}