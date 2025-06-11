package SpiralMatrix;

import java.util.*;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int dir = 0, cnt = 1;
        int h = matrix.length, w = matrix[0].length;
        int fi = 0, fj = 0;
        int[] di = new int[]{0,1,0,-1};
        int[] dj = new int[]{1,0,-1,0};

        int[][] flag = new int[h][w];
        ans.add(matrix[fi][fj]);
        flag[fi][fj] = 1;

        while(true){
            int ni = fi + di[dir];
            int nj = fj + dj[dir];

            if(cnt == h*w) break;

            if(ni<0 || ni>h-1 || nj<0 || nj>w-1 || flag[ni][nj] == 1){
                dir = (dir+1)%4;
            }
            else{
                cnt++;
                fi = ni;
                fj = nj;
                flag[ni][nj] = 1;
                ans.add(matrix[ni][nj]);
            }
        }

        return ans;
    }
}
