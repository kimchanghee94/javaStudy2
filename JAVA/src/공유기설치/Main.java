package 공유기설치;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        int l=1,r=arr[N-1]-arr[0],ans=0;
        while(l<=r){
            int m=(l+r)/2;
            int f=arr[0];
            int cnt=1;
            for(int i=1;i<N;i++){
                if(arr[i]-f>=m){
                    f=arr[i];
                    cnt++;
                }
            }

            if(cnt<C) r=m-1;
            else{
                l=m+1;
                ans=Math.max(ans,m);
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
