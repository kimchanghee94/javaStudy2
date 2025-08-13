package LongestConsecutiveSequence;

import java.util.*;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        int ans = 0;

        for(int num : nums) hash.add(num);
        for(int num : hash){
            if(!hash.contains(num-1)){
                int tmpAns = 0;
                while(hash.contains(num++)){
                    tmpAns++;
                }
                ans = Math.max(ans, tmpAns);
            }
        }
        return ans;
    }
}

/*
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans=0;
        for(int num:nums) set.add(num);
        for(int num:set){
            if(!set.contains(num-1)){
                int cnt=0;
                while(set.contains(num++)) cnt++;
                ans=Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
*/