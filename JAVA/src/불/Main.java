package 불;
import java.io.*;
import java.util.*;

public class Main {
    private static final int[] di={1,0,-1,0},dj={0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] board = new char[R][C];
        for(int i=0;i<R;i++) board[i]=br.readLine().toCharArray();
        int ans=bfs(R,C,board);
        bw.write(ans==0 ? "IMPOSSIBLE" : String.valueOf(ans));
        br.close();
        bw.close();
    }
    private static int bfs(int R, int C, char[][] board){
        Queue<int[]> jq = new LinkedList<>();
        Queue<int[]> fq = new LinkedList<>();
        for(int i=0;i<R;i++) for(int j=0;j<C;j++) {
            if(board[i][j]=='J') jq.offer(new int[]{i,j});
            else if(board[i][j]=='F') fq.offer(new int[]{i,j});
        }

        int ans=1;
        while(!jq.isEmpty()){
            int size=fq.size();
            for(int i=0;i<size;i++){
                int[] f=fq.poll();
                int fi=f[0], fj=f[1];
                for(int d=0;d<4;d++){
                    int ni=fi+di[d], nj=fj+dj[d];
                    if(ni<0 || ni>=R || nj<0 || nj>=C || board[ni][nj]!='.') continue;
                    board[ni][nj]='F';
                    fq.offer(new int[]{ni,nj});
                }
            }

            size=jq.size();
            for(int i=0;i<size;i++){
                int[] f=jq.poll();
                int fi=f[0], fj=f[1];
                for(int d=0;d<4;d++){
                    int ni=fi+di[d], nj=fj+dj[d];
                    if(ni<0 || ni>=R || nj<0 || nj>=C) return ans;
                    if(board[ni][nj]!='.') continue;
                    board[ni][nj]='J';
                    jq.offer(new int[]{ni,nj});
                }
            }
            ans++;
        }

        return 0;
    }
}
