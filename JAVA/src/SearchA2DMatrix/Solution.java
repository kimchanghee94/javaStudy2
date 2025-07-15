package SearchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length,m=matrix[0].length;
        int l=0,r=m*n-1;
        while(l<=r){
            int mid=(l+r)/2;
            int i=mid/m, j=mid%m;
            if(matrix[i][j]==target) return true;
            if(matrix[i][j]<target) l=mid+1;
            else r=mid-1;
        }
        return false;
    }
}