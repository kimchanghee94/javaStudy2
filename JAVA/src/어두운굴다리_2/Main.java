package 어두운굴다리_2;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans=0, bef=0;
        for(int i=0;i<M;i++){
            int pos = Integer.parseInt(st.nextToken());
            if(i==0) ans=Math.max(ans,pos);
            else ans=Math.max(ans,(pos-bef)/2+(pos-bef)%2);
            if(i==M-1) ans=Math.max(ans,N-pos);
            bef=pos;
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}