package JumpGame2;

public class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int cur = 0;
        int far = 0;

        for(int i=0; i<nums.length-1; i++){
            far = Math.max(far, nums[i] + i);

            if(i == cur){
                ans++;
                cur = far;
            }
        }

        return ans;
    }
}
