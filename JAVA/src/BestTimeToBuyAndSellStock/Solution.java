package BestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int k=0;
        int ans = 0;

        for(int i=1; i<prices.length; i++){
            int tmp = prices[i] - prices[k];

            if(ans < tmp){
                ans = tmp;
            }else if(tmp < 0){
                k=i;
            }
        }
        return ans;
    }
}

/*
class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE, max=0;
        for(int price : prices){
            min=Math.min(min, price);
            max=Math.max(max, price-min);
        }
        return max;
    }
}
*/