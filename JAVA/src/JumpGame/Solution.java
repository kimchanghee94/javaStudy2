package JumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        int zero = 0;

        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] == 0 || nums[i] <= zero){
                zero++;
            }else{
                zero = 0;
            }
        }

        return zero == 0 ? true : false;
    }
}

/*
class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0; i<nums.length; i++){
            if(max < i) return false;
            max=Math.max(max, i+nums[i]);
        }
        return true;
    }
}
*/