package 등수구하기;
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

        int ans=1,i=1;
        if(N>0){
            st = new StringTokenizer(br.readLine());
            for(;i<=N;i++){
                int score = Integer.parseInt(st.nextToken());
                if(score < T) {
                    break;
                }
                if(score != T) ans++;
            }
        }
        if(i>P) bw.write("-1");
        else bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}
