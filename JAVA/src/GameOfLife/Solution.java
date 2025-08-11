package GameOfLife;

public class Solution {
    public void gameOfLife(int[][] board) {
        int N = board.length, M = board[0].length;
        int[] di = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dj = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int neighbor=0;

                for(int k=0; k<8; k++){
                    int ni = i + di[k];
                    int nj = j + dj[k];

                    if(ni>=0 && ni<N && nj>=0 && nj<M){
                        if(board[ni][nj]==1 || board[ni][nj]==2){
                            neighbor++;
                        }
                    }
                }

                if(board[i][j]==0 && neighbor==3) board[i][j]=-1;
                else if(board[i][j]==1 && (neighbor<2 || neighbor>3)) board[i][j]=2;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int val = board[i][j];
                if(val == -1) board[i][j] = 1;
                else if(val == 2) board[i][j] = 0;
            }
        }
    }
}

/*
class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length, n=board[0].length;
        for(int i=0; i<m; i++) for(int j=0; j<n; j++){
            int cnt=chk(i,j,m,n,board);
            if(board[i][j]==0 && cnt==3) board[i][j]=-1;
            else if(board[i][j]==1 && (cnt<2 || cnt>3)) board[i][j]=2;
        }
        for(int i=0; i<m; i++) for(int j=0; j<n; j++) if(board[i][j]==-1) board[i][j]=1; else if(board[i][j]==2) board[i][j]=0;
    }

    private int chk(int si, int sj, int m, int n, int[][] board){
        int[][] dir={{0,-1},{0,1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int cnt=0;
        for(int d=0; d<dir.length; d++){
            int ni=si+dir[d][0], nj=sj+dir[d][1];
            if(ni<0||nj<0||ni>=m||nj>=n) continue;
            if(board[ni][nj]==1 || board[ni][nj]==2) cnt++;
        }
        return cnt;
    }
}
*/