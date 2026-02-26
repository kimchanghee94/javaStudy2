package 블로그_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int sum=0;

        for(int i=0;i<X;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }
        int max=sum, cnt=1;
        for(int i=X;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum+=(arr[i]-arr[i-X]);
            if(max==sum) cnt++;
            else if(max<sum){
                cnt=1;
                max=sum;
            }
        }

        if(max==0) bw.write("SAD");
        else bw.write(max+"\n"+cnt);
        br.close();
        bw.close();
    }
}