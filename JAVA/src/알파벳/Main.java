package 알파벳;
import java.io.*;
import java.util.*;

public class Main {
    private static int R,C,ans;
    private static char[][] board;
    private static int[][] flag;
    private static final int[] di={1,0,-1,0}, dj={0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        flag = new int[R][C];
        for(int i=0;i<R;i++) board[i]=br.readLine().toCharArray();
        dfs(0,0,1,0);
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static void dfs(int si, int sj, int cnt, int bitmask){
        bitmask|=1<<(board[si][sj]-'A');
        if(flag[si][sj]==bitmask) return;
        ans=Math.max(ans,cnt);
        flag[si][sj]=bitmask;
        for(int d=0;d<4;d++) {
            int ni=si+di[d], nj=sj+dj[d];
            if(ni<0||ni>=R||nj<0||nj>=C||(bitmask&1<<(board[ni][nj]-'A'))!=0) continue;
            dfs(ni,nj,cnt+1,bitmask);
        }
    }
}
