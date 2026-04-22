package 전구와스위치_2;
import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        char[] src = br.readLine().toCharArray();
        char[] dest = br.readLine().toCharArray();

        int ans = Integer.MAX_VALUE;
        for(int i=0;i<2;i++) ans = Math.min(ans, greedy(src.clone(), dest, i));

        bw.write(ans==Integer.MAX_VALUE ? "-1" : String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static int greedy(char[] src, char[] dest, int idx){
        int cnt=0;
        if(idx==0){
            change(src,idx);
            cnt++;
        }
        for(int i=1;i<N;i++){
            if(src[i-1]!=dest[i-1]){
                change(src,i);
                cnt++;
            }
        }
        if(!Arrays.equals(src,dest)) return Integer.MAX_VALUE;
        return cnt;
    }

    private static void change(char[] tmp, int idx){
        if(idx>0) tmp[idx-1] = tmp[idx-1]=='0' ? '1' : '0';
        tmp[idx] = tmp[idx]=='0' ? '1' : '0';
        if(idx<N-1) tmp[idx+1] = tmp[idx+1]=='0' ? '1' : '0';
    }
}