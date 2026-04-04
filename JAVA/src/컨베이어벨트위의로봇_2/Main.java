package 컨베이어벨트위의로봇_2;
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

        st = new StringTokenizer(br.readLine());
        int[] belt = new int[2*N];
        int[] robot = new int[N];
        for(int i=0;i<2*N;i++) belt[i]=Integer.parseInt(st.nextToken());

        while(K>0){
            int tmp=belt[2*N-1];
            for(int i=2*N-1;i>0;i--) belt[i]=belt[i-1];
            belt[0]=tmp;
            for(int i=N-1;i>0;i--) robot[i]=robot[i-1];
            robot[N-1]=robot[0]=0;

            for(int i=N-1;i>0;i--){
                if(belt[i]>0 && robot[i]==0 && robot[i-1]==1){
                    robot[i]=robot[i-1];
                    robot[i-1]=0;
                    if(--belt[i]==0) K--;
                }
            }
            robot[N-1]=0;

            if(belt[0]>0){
                if(--belt[0]==0) K--;
                robot[0]=1;
            }

            ans++;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}