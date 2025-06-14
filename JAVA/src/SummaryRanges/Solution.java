package SummaryRanges;

import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();

        if(nums.length == 0) return ans;
        else if(nums.length == 1){
            ans.add(nums[0] + "");
            return ans;
        }

        int strt = nums[0], end=nums[0];

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]+1 == nums[i+1]) end = nums[i+1];
            else{
                if(strt == end) ans.add(strt + "");
                else ans.add(strt + "->" + end);
                strt = nums[i+1];
                end = nums[i+1];
            }
        }

        if(nums[nums.length-1] == nums[nums.length-2]+1){
            ans.add(strt + "->" + nums[nums.length-1]);
        }else{
            ans.add(nums[nums.length-1] + "");
        }

        return ans;
    }
}
