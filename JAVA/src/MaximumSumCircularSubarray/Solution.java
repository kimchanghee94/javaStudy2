package MaximumSumCircularSubarray;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int maxAns = nums[0], maxCur = 0, minAns = nums[0], minCur = 0;
        for(int num : nums){
            maxCur = Math.max(num, num+maxCur);
            maxAns = Math.max(maxCur, maxAns);

            minCur = Math.min(num, num+minCur);
            minAns = Math.min(minCur, minAns);

            total += num;
        }
        if(maxAns<0) return maxAns;
        return Math.max(maxAns, total-minAns);
    }
}