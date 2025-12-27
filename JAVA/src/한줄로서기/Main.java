package 한줄로서기;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] ans = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int cnt=Integer.parseInt(st.nextToken());
            for(int j=0;j<N;j++){
                if(ans[j]!=0) continue;
                if(cnt==0){
                    ans[j]=i+1;
                    break;
                }
                cnt--;
            }
        }
        for(int i=0;i<N;i++) bw.write(ans[i]+" ");
        br.close();
        bw.close();
    }
}
