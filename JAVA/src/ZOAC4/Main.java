package ZOAC4;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H=Integer.parseInt(st.nextToken())-1;
        int W=Integer.parseInt(st.nextToken())-1;
        int N=Integer.parseInt(st.nextToken())+1;
        int M=Integer.parseInt(st.nextToken())+1;
        int answer=(H/N+1)*(W/M+1);
        bw.write(String.valueOf(answer));
        br.close();
        bw.close();
    }
}