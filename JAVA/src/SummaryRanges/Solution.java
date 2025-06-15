package SummaryRanges;

import java.util.*;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int currentIndex = 0;
        for (int i=0;i < nums.length;i++) {
            if((i+1 < nums.length) && (nums[i] + 1 == nums[i+1])) {
                continue;
            }
            if(currentIndex == i) {
                ans.add(String.valueOf(nums[currentIndex]));
                currentIndex = currentIndex + 1;
                continue;
            }
            ans.add(String.valueOf(nums[currentIndex]) + "->" + String.valueOf(nums[i]));
            currentIndex = i+1;
        }
        return ans;
    }
}
