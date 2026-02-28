package 햄버거분배_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int ans=0;
        boolean[] flag = new boolean[N];
        char[] arr = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            if(arr[i]=='P'){
                int s = Math.max(i-K,0);
                int e = Math.min(i+K,N-1);

                while(s<=e){
                    if(arr[s]=='H' && !flag[s]) {
                        ans++;
                        flag[s]=true;
                        break;
                    }
                    s++;
                }
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}