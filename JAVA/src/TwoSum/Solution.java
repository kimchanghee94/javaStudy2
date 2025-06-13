package TwoSum;

import java.util.*;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int tmp = target-nums[i];
            if(hash.containsKey(tmp)) return new int[]{hash.get(tmp), i};
            else hash.put(nums[i], i);
        }
        return new int[0];
    }
}
