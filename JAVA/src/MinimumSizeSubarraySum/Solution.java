package MinimumSizeSubarraySum;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int total = 0, left = 0;

        for(int i=0; i<nums.length; i++){
            total += nums[i];

            while(total >= target){
                ans = Math.min(ans, i-left+1);
                total -= nums[left];
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
