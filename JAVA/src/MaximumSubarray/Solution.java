package MaximumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, cur = 0;
        for(int num : nums){
            cur = Math.max(num, cur + num);
            ans = Math.max(cur, ans);
        }
        return ans;
    }
}