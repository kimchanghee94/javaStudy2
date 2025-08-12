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

/*
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int val=target-nums[i];
            if(map.containsKey(val)) return new int[]{i,map.get(val)};
            else map.put(nums[i], i);
        }
        return new int[0];
    }
}
*/