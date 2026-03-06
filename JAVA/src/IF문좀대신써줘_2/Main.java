package IF문좀대신써줘_2;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] words = new String[N];
        int[] vals = new int[N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            words[i]=st.nextToken();
            vals[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            int val = Integer.parseInt(br.readLine());
            int l=0,r=N-1;
            int ans=0;
            while(l<=r){
                int mid = (l+r)/2;
                if(vals[mid]>=val){
                    r=mid-1;
                    ans=mid;
                }
                else l=mid+1;
            }
            bw.write(words[ans]+"\n");
        }

        br.close();
        bw.close();
    }
}