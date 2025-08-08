package ThreeSum;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i] == nums[i-1]) continue;

            int left=i+1;
            int right=nums.length-1;

            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum < 0){
                    left++;
                }
                else if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
                }else{
                    right--;
                }
            }
        }

        return ans;
    }
}

/*
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1, r=nums.length-1;
            while(l<r){
                if(nums[i]+nums[l]+nums[r]==0) {
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;r--;
                    while(l<r && nums[l]==nums[l-1]) l++;
                    while(l<r && nums[r]==nums[r+1]) r--;
                }
                else if(nums[i]+nums[l]+nums[r]>0) r--;
                else l++;
            }
        }

        return ans;
    }
}
*/