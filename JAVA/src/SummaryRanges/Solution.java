package SummaryRanges;

import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int N=nums.length;
        int strt=0;

        for(int i=1; i<=N; i++){
            if(i==N||nums[i-1]+1!=nums[i]){
                if(nums[strt]==nums[i-1]) ans.add(nums[strt]+"");
                else ans.add(nums[strt]+"->"+nums[i-1]);
                strt=i;
            }
        }

        return ans;
    }
}

/*
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int strt = 0;
        for(int i=1; i<=nums.length; i++){
            if(i==nums.length || nums[i-1]+1!=nums[i]){
                if(nums[strt]==nums[i-1]) ans.add(String.valueOf(nums[strt]));
                else ans.add(nums[strt]+"->"+nums[i-1]);
                strt=i;
            }
        }
        return ans;
    }
}
*/