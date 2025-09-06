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

/*
class Solution {
    int[] di=new int[]{1,0,-1,0};
    int[] dj=new int[]{0,1,0,-1};
    int M,N;
    public int numIslands(char[][] grid) {
        int ans=0;
        M=grid.length; N=grid[0].length;
        for(int i=0; i<M; i++) for(int j=0; j<N; j++) if(grid[i][j]=='1') {
            dfs(grid, i,j);
            ans++;
        }
        return ans;
    }
    private void dfs(char[][] grid, int si, int sj){
        grid[si][sj]='0';
        for(int d=0; d<4; d++){
            int ni=si+di[d], nj=sj+dj[d];
            if(ni<0||nj<0||ni>=M||nj>=N||grid[ni][nj]=='0') continue;
            dfs(grid, ni, nj);
        }
    }
}
*/