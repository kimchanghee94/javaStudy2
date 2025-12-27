package 창고다각형;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1001];
        int l=1001,r=0;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            arr[L]=R;
            l=Math.min(l,L);
            r=Math.max(r,L);
        }

        int ans=0;
        while(l<=r){
            if(arr[l]<=arr[r]){
                ans+=arr[l];
                arr[l+1]=Math.max(arr[l],arr[l+1]);
                l++;
            }else{
                ans+=arr[r];
                arr[r-1]=Math.max(arr[r],arr[r-1]);
                r--;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
