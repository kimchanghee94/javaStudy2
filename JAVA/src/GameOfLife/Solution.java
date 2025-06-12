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
