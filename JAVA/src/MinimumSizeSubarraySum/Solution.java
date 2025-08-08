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

/*
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,sum=0,ans=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            while(sum>=target){
                ans=Math.min(ans, i-l+1);
                sum-=nums[l++];
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}
*/
