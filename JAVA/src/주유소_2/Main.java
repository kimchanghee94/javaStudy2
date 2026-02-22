package 주유소_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++) dist[i]=Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long ans=0;
        int minPrice=Integer.MAX_VALUE;
        for(int i=0;i<N-1;i++){
            int price = Integer.parseInt(st.nextToken());
            minPrice=Math.min(minPrice,price);
            ans+=(long)minPrice*dist[i];
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}