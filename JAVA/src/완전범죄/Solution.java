package 완전범죄;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = n;
        int size = info.length;
        int dp[][] = new int[size+1][m];

        for(int i=0; i<=size; i++){
            Arrays.fill(dp[i], n);
        }
        dp[0][0] = 0;

        for(int i=1; i<=size; i++){
            int a = info[i-1][0];
            int b = info[i-1][1];

            for(int j=0; j<m; j++){
                //a가 훔친 경우
                dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + a);

                //b가 훔친 경우
                if(j + b < m){
                    dp[i][j+b] = dp[i-1][j];
                }
            }
        }

        for(int i=0; i<m; i++){
            answer = Math.min(answer, dp[size][i]);
        }

        return answer >= n ? -1 : answer;
    }
}
