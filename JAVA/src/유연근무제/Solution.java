package 유연근무제;

import java.util.Arrays;

public class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int[] worker = new int[timelogs.length];
        Arrays.fill(worker, 0);

        //요일
        for(int s=0; s<7; s++){
            //주말 제외
            if((s+startday)%7 == 0 || (s+startday)%7 == 6){
                continue;
            }

            //직원
            for(int i=0; i<timelogs.length; i++){
                if(worker[i] == 0){
                    int hope = schedules[i];
                    int time = timelogs[i][s];

                    if(hope % 100 >= 50){
                        int hour = (hope/100 + 1) * 100;
                        int min = hope%100 - 50;
                        hope = hour + min;
                    }else {
                        hope += 10;
                    }

                    if(hope < time){
                        worker[i] = -1;
                    }
                }
            }
        }

        for(int i=0; i<worker.length; i++){
            if(worker[i] == 0){
                answer++;
            }
        }

        return answer;
    }
}
