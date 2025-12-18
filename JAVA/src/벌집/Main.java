package 벌집;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N=Integer.parseInt(br.readLine());
        int cnt=1,ans=1;

        while(cnt<N){
            cnt+=(ans*6);
            ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
