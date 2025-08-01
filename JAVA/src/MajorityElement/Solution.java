package MajorityElement;

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int ans = 0;

        for(int num : nums){
            if(count == 0) ans = num;
            count += (ans == num) ? 1 : -1;
        }

        return ans;
    }
}

/*
class Solution {
    public int majorityElement(int[] nums) {
        int ans=0, sum=0;
        for(int num:nums){
            if(sum==0) ans=num;
            sum += (ans==num) ? 1:-1;
        }
        return ans;
    }
}
*/