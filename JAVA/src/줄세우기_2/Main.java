package 줄세우기_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int P = Integer.parseInt(br.readLine());
        while(P-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            bw.write(st.nextToken() + " ");
            int[] arr = new int[20];
            int ans=0;
            for(int i=0;i<20;i++){
                arr[i] = Integer.parseInt(st.nextToken());
                int cnt=0;
                for(int j=0;j<i;j++) if(arr[j]>arr[i]) cnt++;
                ans+=cnt;
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}