package ContainsDuplicate2;

import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int N=nums.length;
        Map<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<N;i++){
            if(!hash.containsKey(nums[i])||i-hash.get(nums[i])>k) hash.put(nums[i],i);
            else if(i-hash.get(nums[i])<=k) return true;
        }
        return false;
    }
}

/*
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]) && i-map.get(nums[i]) <= k) return true;
            else map.put(nums[i], i);
        }
        return false;
    }
}
*/