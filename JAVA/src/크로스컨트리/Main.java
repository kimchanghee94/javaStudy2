package 크로스컨트리;
import java.io.*;
import java.util.*;
public class Main {
    private static final int MAX=201;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int[] teams = new int[N];
            int[][] board = new int[MAX][4];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                int team = Integer.parseInt(st.nextToken());
                teams[i]=team;
                board[team][0]++;
            }

            int ans=0;
            for(int i=0,rank=0; i<N; i++){
                int team = teams[i];
                if(board[team][0]<6) continue;
                board[team][1]++;
                rank++;
                if(board[team][1]<5) board[team][2]+=rank;
                else if(board[team][1]==5) board[team][3]=rank;
                ans=team;
            }

            for(int i=1;i<MAX;i++){
                if(board[i][0]<6) continue;
                if(board[ans][2]>board[i][2]) ans=i;
                else if(board[ans][2]==board[i][2] && board[ans][3]>board[i][3]) ans=i;
            }

            bw.write(String.valueOf(ans));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}