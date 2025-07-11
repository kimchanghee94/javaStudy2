package Permutations;
import java.util.*;
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();
    boolean[] flag = new boolean[25];

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return ans;
    }

    private void backtrack(int[] nums){
        if(nums.length == arr.size()) ans.add(new ArrayList<>(arr));
        else{
            for(int i=0; i<nums.length; i++){
                if(!flag[nums[i]+10]){
                    flag[nums[i]+10]=true; arr.add(nums[i]);
                    backtrack(nums);
                    flag[nums[i]+10]=false; arr.remove(arr.size()-1);
                }
            }
        }
    }
}
