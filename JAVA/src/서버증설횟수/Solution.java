package 서버증설횟수;

import java.util.Arrays;

public class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server = new int[25];
        Arrays.fill(server, 0);

        for(int i=0; i<players.length; i++){
            int user = players[i];
            int need = user/m;

            //기존 서버 몇대가 켜져있는지
            int total = 0;
            for(int j=1; j<k && i-j >= 0; j++){
                total += server[i-j];
            }

            //서버 증설이 필요한경우
            if(need > total){
                server[i] = need - total;
                answer += server[i];
            }
        }

        return answer;
    }
}
