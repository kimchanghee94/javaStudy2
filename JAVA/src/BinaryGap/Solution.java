package BinaryGap;

public class Solution {
    public int solution(int N) {
        String str = Integer.toBinaryString(N);
        int answer = 0;

        for(int i=0; i<str.length(); i++){
            int tmp = 0;

            if(str.charAt(i) == '0'){
                for(int j=i; j<str.length(); j++){
                    if(str.charAt(j) == '0'){
                        tmp++;
                    }else if(str.charAt(j) == '1' && j != str.length()-1){
                        answer = Math.max(answer, tmp);
                        i=j;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
