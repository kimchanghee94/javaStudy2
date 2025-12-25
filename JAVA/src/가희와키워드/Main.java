package 가희와키워드;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i=0;i<N;i++) set.add(br.readLine());
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()){
                String word = st.nextToken();
                if(set.contains(word)) set.remove(word);
            }
            bw.write(set.size()+"\n");
        }

        br.close();
        bw.close();
    }
}