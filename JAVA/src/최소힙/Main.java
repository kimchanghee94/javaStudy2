package 최소힙;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(N-->0){
            int val = Integer.parseInt(br.readLine());
            if(val==0){
                if(pq.isEmpty()) bw.write("0\n");
                else bw.write(pq.poll()+"\n");
            }else pq.offer(val);
        }

        br.close();
        bw.close();
    }
}
