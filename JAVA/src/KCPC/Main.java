package KCPC;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[][] board = new int[n+1][3];
            int[][] prob = new int[n+1][k+1];

            for(int idx=0;idx<m;idx++){
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                if(prob[i][j]<s){
                    board[i][0]-=prob[i][j];
                    prob[i][j]=s;
                    board[i][0]+=prob[i][j];
                }
                board[i][1]++;
                board[i][2]=idx;
            }

            int ans=1;
            for(int i=1;i<=n;i++){
                if(board[i][0]>board[t][0]) ans++;
                else if(board[i][0]==board[t][0]){
                    if(board[i][1]<board[t][1]) ans++;
                    else if(board[i][1]==board[t][1]){
                        if(board[i][2]<board[t][2]) ans++;
                    }
                }
            }
            bw.write(ans+"\n");
        }

        br.close();
        bw.close();
    }
}
