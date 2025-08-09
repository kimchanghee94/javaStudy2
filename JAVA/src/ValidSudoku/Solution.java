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

/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for(int i=0; i<9; i++) for(int j=0; j<9; j++){
            if(board[i][j]=='.') continue;
            int val=board[i][j]-'1';
            if(row[i][val]) return false;
            row[i][val]=true;
            if(col[j][val]) return false;
            col[j][val]=true;
            int bIdx=((i/3)*3)+(j/3);
            if(box[bIdx][val]) return false;
            box[bIdx][val]=true;
        }
        return true;
    }
}
*/