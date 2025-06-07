package MinimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;

        int fir=0, sec=0;
        int total = nums[fir];

        while(sec < nums.length && fir <= sec){
            if(total < target){
                if(sec+1 == nums.length){
                    break;
                }else{
                    sec++;
                    total += nums[sec];
                }
            }else{
                total-=nums[fir];
                ans = Math.min(ans, sec-fir+1);

                fir++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
