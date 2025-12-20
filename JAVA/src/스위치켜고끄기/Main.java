package 스위치켜고끄기;
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sMap = new int[N];
        for(int i=0; i<N; i++) sMap[i]=Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(br.readLine());
        for(int i=0; i<S; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            if(sex==1) {
                for (int j=1; j<=N; j++) if(j%val == 0) sMap[j-1]=(sMap[j-1]==1?0:1);
            }
            else {
                int j=0;
                val--;
                while(val-j>=0 && val+j<N && sMap[val-j]==sMap[val+j]){
                    sMap[val-j]=sMap[val+j]=sMap[val-j]==1?0:1;
                    j++;
                }
            }
        }
        for(int i=0;i<N;i++) {
            bw.write(sMap[i]+" ");
            if((i+1)%20==0) bw.newLine();
        }
        br.close();
        bw.close();
    }
}