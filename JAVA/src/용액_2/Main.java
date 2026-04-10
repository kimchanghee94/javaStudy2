package 용액_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());

        int l=0,r=N-1;
        int ans1=0,ans2=0;
        int ans=Integer.MAX_VALUE;
        while(l<r){
            int sum=arr[l]+arr[r];
            if(ans>Math.abs(sum)){
                ans1=arr[l];
                ans2=arr[r];
                ans=Math.abs(sum);
            }
            if(sum>0) r--;
            else l++;
        }

        bw.write(ans1+" "+ans2);
        br.close();
        bw.close();
    }
}