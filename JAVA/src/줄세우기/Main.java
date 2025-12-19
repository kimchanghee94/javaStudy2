package 줄세우기;
import java.io.*;
import java.util.*;
public class Main {
    private static final int MAX=20;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int P = Integer.parseInt(br.readLine());
        while(P-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int ans = 0;
            int[] arr = new int[MAX];
            for(int i=0;i<MAX;i++) arr[i]=Integer.parseInt(st.nextToken());
            for(int i=0;i<MAX;i++) for(int j=0;j<i;j++) if(arr[j]>arr[i]) ans++;

            bw.write(T+" "+ans);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}