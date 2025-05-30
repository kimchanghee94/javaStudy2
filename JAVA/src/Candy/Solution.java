package Candy;

import java.util.*;

public class Solution {
    public int candy(int[] ratings) {
        int max = 1, len = ratings.length;
        int[] candies = new int[len];
        Arrays.fill(candies, 1);

        for(int i=1; i<len; i++){
            if(ratings[i] > ratings[i-1]){
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i=len-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]){
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int sum = 0;
        for(int i=0; i<len; i++){
            sum+=candies[i];
        }
        return sum;
    }
}
