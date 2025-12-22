package 블로그;
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
        for(int i=0;i<X;i++) {
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i];
        }

        int ans=sum,cnt=1;
        for(int i=X;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            sum+=arr[i]-arr[i-X];
            if(ans==sum) cnt++;
            else if(ans<sum) {
                ans=sum;
                cnt=1;
            }
        }

        if(ans==0) bw.write("SAD");
        else bw.write(ans+"\n"+cnt);
        br.close();
        bw.close();
    }
}
