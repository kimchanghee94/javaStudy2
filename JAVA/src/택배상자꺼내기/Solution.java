package 택배상자꺼내기;

import java.util.Arrays;

public class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        final int N = 100, M = 10;

        //택배 상자 배열 초기화
        int map[][] = new int[N][M];
        for(int i=0; i<N; i++){
            Arrays.fill(map[i], 0);
        }

        //택배상자 채우기
        for(int i=1, j=0; i<=n; i++){
            int k = i%w - 1;
            //마지막 다 채운 경우
            if(k == -1){
                k = w-1;
            }

            //우측으로
            if(j%2 == 0){
                map[j][k] = i;
            }
            //좌측으로
            else{
                map[j][w-k-1] = i;
            }

            //한칸 위로 올리기
            if(k == w-1){
                j++;
            }
        }

        //택배상자 찾기
        for(int i=0; i<N && answer == 0; i++){
            for(int j=0; j<w && answer == 0; j++){
                //택배 상자를 찾았을 경우
                if(map[i][j] == num){
                    //위로 몇개의 택배가 있는지 카운트
                    for(int k=i; k<N && map[k][j] != 0; k++){
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
