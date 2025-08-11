package SetMatrixZeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        int M=matrix.length, N=matrix[0].length;
        boolean firR=false, firC=false;

        for(int i=0; i<N; i++) if(matrix[0][i] == 0) firR = true;
        for(int i=0; i<M; i++) if(matrix[i][0] == 0) firC = true;
        for(int i=0; i<M; i++) for(int j=0; j<N; j++)
            if(matrix[i][j] == 0){
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        for(int i=1; i<M; i++) for(int j=1; j<N; j++) if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
        if(firR == true) for(int i=0; i<N; i++) matrix[0][i] = 0;
        if(firC == true) for(int i=0; i<M; i++) matrix[i][0] = 0;
    }
}

/*
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean cflag=false,rflag=false;
        int m=matrix.length, n=matrix[0].length;
        for(int i=0; i<n && !rflag; i++) if(matrix[0][i]==0) rflag=true;
        for(int i=0; i<m && !cflag; i++) if(matrix[i][0]==0) cflag=true;
        for(int i=1; i<m; i++) for(int j=1; j<n; j++) if(matrix[i][j]==0) {
            matrix[i][0]=0;
            matrix[0][j]=0;
        }
        for(int i=1; i<m; i++) for(int j=1; j<n; j++) if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
        if(rflag) for(int i=0; i<n; i++) matrix[0][i]=0;
        if(cflag) for(int i=0; i<m; i++) matrix[i][0]=0;
    }
}
*/