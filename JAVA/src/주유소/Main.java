package 주유소;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[N-1];
        for(int i=0;i<N-1;i++) dist[i] = Integer.parseInt(st.nextToken());

        long ans=0, minPrice=1_000_000_000L;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N-1;i++){
            long price = Long.parseLong(st.nextToken());
            minPrice = Math.min(minPrice,price);
            ans+=dist[i]*minPrice;
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
