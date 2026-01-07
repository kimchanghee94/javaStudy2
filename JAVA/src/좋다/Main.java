package 좋다;
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
        Arrays.sort(arr);
        int ans=0;
        for(int i=0;i<N;i++){
            int l=0,r=N-1;
            if(i==0) l=1;
            if(i==N-1) r=N-2;

            while(l<r){
                int val=arr[l]+arr[r];

                if(val==arr[i]){
                    ans++;
                    break;
                }else if(val>arr[i]) r--;
                else l++;

                if(i==l) l++;
                if(i==r) r--;
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
