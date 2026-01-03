package 용액;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i]=Integer.parseInt(st.nextToken());
        int l=0, r=N-1, tmp=2_000_000_000;
        int[] ans=new int[2];
        while(l<r){
            int val=arr[l]+arr[r];
            if(tmp>Math.abs(val)){
                ans[0]=arr[l];
                ans[1]=arr[r];
                tmp=Math.abs(val);
            }
            if(val<=0) l++;
            else r--;
        }
        bw.write(ans[0]+" "+ans[1]);
        br.close();
        bw.close();
    }
}
