package ValidSudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                int c = board[i][j]-'1';

                row[i][c]++;
                if(row[i][c] > 1) return false;

                col[j][c]++;
                if(col[j][c] > 1) return false;

                int bIdx = i/3 + (j/3)*3;
                box[bIdx][c]++;
                if(box[bIdx][c] > 1) return false;
            }
        }

        return true;
    }
}
