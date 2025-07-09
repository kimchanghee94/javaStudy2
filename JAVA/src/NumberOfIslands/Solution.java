package NumberOfIslands;

public class Solution {
    int[] di = new int[]{1,0,-1,0};
    int[] dj = new int[]{0,1,0,-1};
    int N,M;

    public int numIslands(char[][] grid) {
        int ans=0;
        N=grid.length;
        M=grid[0].length;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(grid[i][j] == '1'){
                    ans++;
                    grid[i][j] = '0';
                    dfs(grid, i, j);
                }
            }
        }

        return ans;
    }

    private void dfs(char[][] grid, int fi, int fj){
        for(int i=0; i<4; i++){
            int ni=fi+di[i];
            int nj=fj+dj[i];
            if(0<=ni && ni<N && 0<=nj && nj<M && grid[ni][nj]=='1'){
                grid[ni][nj] = '0';
                dfs(grid,ni,nj);
            }
        }
    }
}