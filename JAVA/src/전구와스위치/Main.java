package 전구와스위치;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX = 100001;
    private static int N;
    private static char[] s,e;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        s = br.readLine().toCharArray();
        e = br.readLine().toCharArray();
        int ans=MAX;
        for(int i=0;i<2;i++) ans=Math.min(ans, greedy(s.clone(), i));
        if(ans==MAX) bw.write("-1");
        else bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void change(char[] a, int idx){
        if(idx>0) a[idx-1]=a[idx-1]=='0' ? '1':'0';
        a[idx]=a[idx]=='0' ? '1':'0';
        if(idx<N-1) a[idx+1]=a[idx+1]=='0' ? '1':'0';
    }

    private static int greedy(char[] tmp, int idx){
        int cnt=0;
        if(idx==0) {
            change(tmp, 0);
            cnt++;
        }
        for(int i=1;i<N;i++){
            if(tmp[i-1]!=e[i-1]) {
                change(tmp, i);
                cnt++;
            }
        }
        if(!Arrays.equals(tmp,e)) return MAX;
        else return cnt;
    }
}
