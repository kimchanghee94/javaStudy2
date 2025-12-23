package 햄버거분배;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();

        int ans=0;
        for(int i=0;i<N;i++){
            if(arr[i]=='H' || arr[i]=='X') continue;
            for(int j=i-K;j<=i+K;j++){
                if(j<0 || j>=N) continue;
                if(arr[j]=='H'){
                    arr[j]='X';
                    ans++;
                    break;
                }
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
