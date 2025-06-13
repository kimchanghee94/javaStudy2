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
