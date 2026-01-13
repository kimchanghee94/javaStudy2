package 하늘에서별똥별빗발친다;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] stars = new int[K][2];
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i][0]=x;
            stars[i][1]=y;
        }
        int ans=0;
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                int fi=stars[i][0], fj=stars[j][1];
                int tmp=0;
                for(int k=0;k<K;k++){
                    int ni=stars[k][0], nj=stars[k][1];
                    if(fi<=ni && ni<=fi+L && fj<=nj && nj<=fj+L) tmp++;
                }
                ans=Math.max(ans,tmp);
            }
        }
        bw.write(String.valueOf(K-ans));
        br.close();
        bw.close();
    }
}