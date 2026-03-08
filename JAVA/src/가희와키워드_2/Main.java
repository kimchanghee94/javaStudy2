package 가희와키워드_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> keyword = new HashSet<>();
        for(int i=0;i<N;i++) keyword.add(br.readLine());
        for(int i=0;i<M;i++) {
            String[] words = br.readLine().split(",");
            for(String word : words) keyword.remove(word);
            bw.write(keyword.size()+"\n");
        }

        br.close();
        bw.close();
    }
}