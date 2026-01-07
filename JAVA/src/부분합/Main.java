package 부분합;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int ans=N+1,l=0,slide=0;
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
            slide+=arr[i];
            while(slide>=S) {
                ans=Math.min(ans,i-l+1);
                slide-=arr[l];
                l++;
            }
        }
        if(ans==N+1) bw.write("0");
        else bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
