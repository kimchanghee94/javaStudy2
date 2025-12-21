package 어두운굴다리;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int ans=0,pos=0;
        for(int i=0;i<M;i++) {
            int tmp=pos;
            pos=Integer.parseInt(st.nextToken());
            if(i==0) ans=pos-tmp;
            else ans=Math.max(ans,(pos-tmp)/2+(pos-tmp)%2);
        }
        ans=Math.max(ans,N-pos);

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}