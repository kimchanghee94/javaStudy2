package N번째큰수;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int val = Integer.parseInt(st.nextToken());
                pq.offer(val);
                if(pq.size()==N+1) pq.poll();
            }
        }

        bw.write(String.valueOf(pq.peek()));
        br.close();
        bw.close();
    }
}
