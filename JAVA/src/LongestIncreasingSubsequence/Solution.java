package LongestIncreasingSubsequence;
import java.util.*;
public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int num : nums){
            int idx = Collections.binarySearch(ans, num);
            if(idx<0) idx=-(idx+1);
            if(idx==ans.size()) ans.add(num);
            else ans.set(idx, num);
        }
        return ans.size();
    }
}