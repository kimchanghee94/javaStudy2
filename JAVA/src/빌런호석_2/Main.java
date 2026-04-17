package 빌런호석_2;
import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map = {
            {0,4,3,3,4,3,2,3,1,2},
            {4,0,5,3,2,5,6,1,5,4},
            {3,5,0,2,5,4,3,4,2,3},
            {3,3,2,0,3,2,3,2,2,1},
            {4,2,5,3,0,3,4,3,3,2},
            {3,5,4,2,3,0,1,4,2,1},
            {2,6,3,3,4,1,0,5,1,2},
            {3,1,4,2,3,4,5,0,4,3},
            {1,5,2,2,3,2,1,4,0,1},
            {2,4,3,1,2,1,2,3,1,0},
    };

    private static int N,K,P,ans=0;
    private static StringBuilder word = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        String X = st.nextToken();

        for(int i=0;i<K-X.length();i++) word.append("0");
        word.append(X);
        dfs(new StringBuilder());
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void dfs(StringBuilder sb){
        if(sb.length()==K){
            int val = Integer.parseInt(sb.toString());
            if(val==0 || val>N || sb.toString().equals(word.toString())) return;
            int tot=0;
            for(int i=0;i<K;i++){
                int f = word.charAt(i)-'0';
                int s = sb.charAt(i)-'0';
                tot+=map[f][s];
            }
            if(tot<=P) ans++;
        }else{
            for(int i=0;i<10;i++){
                sb.append(i);
                dfs(sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}