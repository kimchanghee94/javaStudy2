package 벌집_2;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int val=1, ans=1;
        while(val<N) val+=((ans++)*6);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}