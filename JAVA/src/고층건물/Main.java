package 고층건물;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int ans=0;
        for(int i=0;i<N;i++){
            int show=0;
            double m=1_000_000_005;
            for(int j=i-1;j>=0;j--){
                double tmp=(double)(arr[i]-arr[j])/(i-j);
                if(m>tmp){
                    show++;
                    m=tmp;
                }
            }
            m=-1_000_000_005;
            for(int j=i+1;j<N;j++){
                double tmp=(double)(arr[j]-arr[i])/(j-i);
                if(m<tmp){
                    show++;
                    m=tmp;
                }
            }
            ans=Math.max(ans,show);
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}