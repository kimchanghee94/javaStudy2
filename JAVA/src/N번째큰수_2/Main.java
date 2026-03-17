package N번째큰수_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int val = Integer.parseInt(st.nextToken());
                pq.offer(val);
                if(pq.size()==N+1) pq.poll();
            }
        }
        bw.write(String.valueOf(pq.poll()));
        br.close();
        bw.close();
    }
}