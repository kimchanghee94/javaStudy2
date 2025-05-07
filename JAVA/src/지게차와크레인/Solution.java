package 지게차와크레인;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Solution {
    final int[] di = {1,-1,0,0};
    final int[] dj = {0,0,1,-1};

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        Queue<Point> q = new LinkedList<>();
        int h = storage.length;
        int w = storage[0].length();
        char[][] map = new char[h][w];

        //배열 초기화
        for(int i=0; i<h; i++){
            map[i] = storage[i].toCharArray();
        }

        for(int rIdx = 0; rIdx < requests.length; rIdx++){
            char alpha = requests[rIdx].charAt(0);
            int rSize = requests[rIdx].length();

            for(int hIdx=0; hIdx<h; hIdx++){
                for(int wIdx=0; wIdx<w; wIdx++){
                    if(map[hIdx][wIdx] == alpha){

                        //bfs처리가 필요없음
                        if(rSize == 2){
                            map[hIdx][wIdx] = '0';
                        }
                        //bfs처리 필요
                        else{
                            q.offer(new Point(hIdx, wIdx));

                            int flag[][] = new int[h][w];
                            for(int i=0; i<h; i++){
                                Arrays.fill(flag[i], 0);
                            }

                            flag[hIdx][wIdx] = 1;

                            while (!q.isEmpty()){
                                Point p = q.poll();

                                for(int d=0; d<4; d++){
                                    int i = p.x + di[d];
                                    int j = p.y + dj[d];

                                    //바깥과 연결되있는 경우
                                    if(i < 0 || i > h-1 || j<0 || j>w-1){
                                        q.clear();
                                        map[hIdx][wIdx] = '1';
                                    }else if(flag[i][j] == 0 && map[i][j] == '0'){
                                        flag[i][j] = 1;
                                        q.offer(new Point(i, j));
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //이번턴에 임시 예약된 컨테이너 제거
            for(int i=0; i<h; i++){
                for(int j=0; j<w; j++){
                    if(map[i][j] == '1'){
                        map[i][j] = '0';
                    }
                }
            }
        }

        //남아있는 알파벳 컨테이너 개수 체크
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(map[i][j] != '0'){
                    answer++;
                }
            }
        }

        return answer;
    }
}
