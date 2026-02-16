package 등수구하기_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if(N>0) st = new StringTokenizer(br.readLine());
        int idx=-1, rank=1;
        for(int i=0;i<N;i++){
            int val = Integer.parseInt(st.nextToken());
            if(val>T) rank++;
            if(val<T) {
                idx=i;
                break;
            }
        }
        if(idx==-1 && N==P) bw.write("-1");
        else bw.write(String.valueOf(rank));

        br.close();
        bw.close();
    }
}
