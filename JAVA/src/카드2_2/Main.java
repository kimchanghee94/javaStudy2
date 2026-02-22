package 카드2_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=N;i++) q.offer(i);
        while(q.size()>1){
            q.poll();
            q.offer(q.poll());
        }
        bw.write(String.valueOf(q.poll()));
        br.close();
        bw.close();
    }
}