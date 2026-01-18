package 일의개수세기;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new  StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        bw.write(String.valueOf(calc(B)-calc(A-1)));
        br.close();
        bw.close();
    }
    private static long calc(long val){
        long sum=0;
        for(int i=0;i<55;i++){
            long rot = (long)1<<(i+1);
            long one = (long)1<<i;
            long cnt = ((val+1)/rot)*one;
            long rem = (val+1)%rot;
            sum+=cnt;
            if(rem>one) sum+=rem-one;
        }
        return sum;
    }
}