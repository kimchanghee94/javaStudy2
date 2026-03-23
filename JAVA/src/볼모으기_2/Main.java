package 볼모으기_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int lr=0;
        for(char c : arr) if(c=='R') lr++;
        int rr=lr, lb=N-lr, rb=N-lr;
        for(int i=0;i<N && arr[i]=='R'; i++) lr--;
        for(int i=N-1;i>=0 && arr[i]=='R'; i--) rr--;
        for(int i=0;i<N && arr[i]=='B'; i++) lb--;
        for(int i=N-1;i>=0 && arr[i]=='B'; i--) rb--;

        bw.write(String.valueOf(Math.min(Math.min(lr,rr), Math.min(lb,rb))));
        br.close();
        bw.close();
    }
}