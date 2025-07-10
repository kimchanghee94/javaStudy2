package SnakeAndLadders;

import java.util.*;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int N = board.length;
        int[] graph = new int[N*N+5];
        int[] flag = new int[N*N+5];

        int ans=1;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i%2==0) graph[ans++] = board[N-i-1][j];
                else graph[ans++] = board[N-i-1][N-j-1];
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        flag[1] = 1;
        ans=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int strt = q.poll();
                if(strt == N*N) return ans;
                for(int j=1; j<=6; j++){
                    int next = strt+j;
                    if(next > N*N) continue;
                    if(graph[next]!=-1) next = graph[next];
                    if(flag[next] != 1){
                        flag[next] = 1;
                        q.offer(next);
                    }
                }
            }
            ans++;
        }

        return -1;
    }
}
