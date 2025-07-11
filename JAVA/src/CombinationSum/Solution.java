package CombinationSum;
import java.util.*;
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int idx){
        if(target==0)ans.add(new ArrayList<>(arr));
        else{
            for(int i=idx; i<candidates.length; i++){
                if(target<candidates[i]) continue;
                arr.add(candidates[i]);
                backtrack(candidates, target-candidates[i], i);
                arr.remove(arr.size()-1);
            }
        }
    }
}