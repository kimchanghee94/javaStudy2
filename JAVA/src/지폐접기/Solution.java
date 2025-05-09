package 지폐접기;

import java.util.Arrays;

public class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        int billMin = Arrays.stream(bill).min().getAsInt();
        int billMax = Arrays.stream(bill).max().getAsInt();
        int walletMin = Arrays.stream(wallet).min().getAsInt();
        int walletMax = Arrays.stream(wallet).max().getAsInt();

        while(billMin > walletMin || billMax > walletMax){
            if(bill[0] > bill[1]){
                bill[0] /= 2;
            }else{
                bill[1] /= 2;
            }

            billMin = Arrays.stream(bill).min().getAsInt();
            billMax = Arrays.stream(bill).max().getAsInt();

            answer++;
        }

        return answer;
    }
}
