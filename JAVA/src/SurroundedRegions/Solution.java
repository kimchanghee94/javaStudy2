package SurroundedRegions;

public class Solution {
    int N,M;
    int[] di = {1,0,-1,0};
    int[] dj = {0,1,0,-1};

    public void solve(char[][] board) {
        N=board.length;
        M=board[0].length;

        for(int i=0; i<N; i++){
            if(board[i][0]=='O') dfs(board, i, 0);
            if(board[i][M-1]=='O') dfs(board, i, M-1);
        }
        for(int i=0; i<M; i++){
            if(board[0][i]=='O') dfs(board, 0, i);
            if(board[N-1][i]=='O') dfs(board, N-1, i);
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int fi, int fj){
        if(fi<0 || fi==N || fj<0 || fj==M || board[fi][fj]!='O') return;
        board[fi][fj]='#';
        for(int i=0; i<4;i++){
            int ni=fi+di[i], nj=fj+dj[i];
            dfs(board, ni, nj);
        }
    }
}