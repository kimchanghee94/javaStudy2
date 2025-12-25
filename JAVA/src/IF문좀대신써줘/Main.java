package IF문좀대신써줘;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] names = new String[N];
        int[] powers = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            int power = Integer.parseInt(br.readLine());
            int l=0, r=N-1, ans=0;
            while(l<=r){
                int m = (l+r)/2;
                if(powers[m]>=power) {
                    ans=m;
                    r=m-1;
                }
                else if(powers[m]<power) l=m+1;
            }
            bw.write(names[ans]+"\n");
        }

        br.close();
        bw.close();
    }
}
