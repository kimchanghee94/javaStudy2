package 컨베이어벨트위의로봇;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())*2;
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int ans=0;
        for(int i=0;i<N;i++) A[i] = Integer.parseInt(st.nextToken());
        while(K>0){
            int tmp = A[N-1];
            for(int i=N-1;i>0;i--) A[i]=A[i-1];
            A[0]=tmp;
            for(int i=N/2-1;i>0;i--) B[i]=B[i-1];
            B[N/2-1]=0; B[0]=0;

            for(int i=N/2-1;i>=0;i--){
                if(B[i]==1 && B[i+1]==0 && A[i+1]!=0) {
                    if(i!=N/2-1) B[i+1]=1;
                    B[i]=0;
                    if(--A[i+1]==0) K--;
                }
            }

            if(A[0]!=0) {
                if(--A[0]==0) K--;
                B[0]=1;
            }
            ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
