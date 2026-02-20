package 크로스컨트리_2;
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX=201;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] teams = new int[MAX][4];
            int[] arr = new int[N];
            for(int i=0;i<N;i++){
                int team=Integer.parseInt(st.nextToken());
                arr[i]=team;
                teams[team][0]++;
            }

            int rank=1;
            int minT=Integer.MAX_VALUE, minS=Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                int team=arr[i];
                if(teams[team][0]<6) continue;
                teams[team][1]++;
                if(teams[team][1]<5) teams[team][2]+=rank;
                else if(teams[team][1]==5) teams[team][3]=rank;
                else if(teams[team][1]==6){
                    if(teams[team][2]<minS){
                        minS=teams[team][2];
                        minT=team;
                    }else if(teams[team][2]==minS && teams[team][3]<teams[minT][3]){
                        minT=team;
                    }
                }
                rank++;
            }
            bw.write(minT+"\n");
        }
        br.close();
        bw.close();
    }
}