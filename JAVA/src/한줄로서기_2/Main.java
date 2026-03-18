package 한줄로서기_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i=1;i<=N;i++) {
            int val = Integer.parseInt(st.nextToken());
            for(int j=0;j<N;j++){
                if(val>0 && arr[j]==0) val--;
                else if(val==0 && arr[j]==0){
                    arr[j]=i;
                    break;
                }
            }
        }
        for(int num : arr) bw.write(num+" ");
        br.close();
        bw.close();
    }
}