package ListOfUniqueNumbers;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        boolean[] flag = new boolean[100001];
        int l=0;
        long ans=0;
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(flag[arr[i]]) {
                ans+=((long)(i-l)*(i-l+1))/2;
                while(flag[arr[i]]) flag[arr[l++]]=false;
                ans-=((long)(i-l)*(i-l+1))/2;
            }
            if(i==N-1) ans+=((long)(i-l+1)*(i-l+2))/2;
            flag[arr[i]]=true;
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}