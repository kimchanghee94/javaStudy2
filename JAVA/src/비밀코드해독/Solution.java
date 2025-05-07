package 비밀코드해독;

public class Solution {
    static int N, answer = 0;
    static int[][] Q;
    static int[] ANS;
    public int solution(int n, int[][] q, int[] ans) {
        N = n;
        Q = q;
        ANS = ans;
        int[] arr = new int[5];
        backtrack(arr, 0);

        return answer;
    }

    void backtrack(int[] arr, int cnt){
        if(cnt == 5){
            boolean flag = true;

            for(int i=0; i<Q.length; i++){
                int result = 0;

                for(int j=0; j<Q[i].length; j++){
                    for(int k=0; k<arr.length; k++){
                        if(Q[i][j] == arr[k]){
                            result++;
                        }
                    }
                }

                if(result != ANS[i]){
                    flag = false;
                    break;
                }
            }

            if(flag == true){
                answer++;
            }
        }else{
            for(int i=1; i<=N; i++){
                if(cnt > 0 && arr[cnt - 1] < i){
                    arr[cnt] = i;
                    backtrack(arr, cnt + 1);
                }else if(cnt == 0){
                    arr[cnt] = i;
                    backtrack(arr, cnt + 1);
                }
            }
        }
    }
}
