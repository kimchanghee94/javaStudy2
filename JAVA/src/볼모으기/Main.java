package 볼모으기;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String balls = br.readLine();
        int lr=0,lb=0,rr=0,rb=0;
        for(int i=0; i<N; i++) if(balls.charAt(i)=='R') lr++;
        rr=lr;
        lb=rb=N-rr;
        for(int i=0;i<N && balls.charAt(i)=='R';i++) lr--;
        for(int i=0;i<N && balls.charAt(i)=='B';i++) lb--;
        for(int i=N-1;i>=0 && balls.charAt(i)=='R';i--) rr--;
        for(int i=N-1;i>=0 && balls.charAt(i)=='B';i--) rb--;
        bw.write(String.valueOf(Math.min(Math.min(lr,rr),Math.min(lb,rb))));
        br.close();
        bw.close();
    }
}