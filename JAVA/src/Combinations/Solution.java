package Combinations;

import java.util.*;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, new ArrayList<>());
        return ans;
    }
    private void backtrack(int n, int k, List<Integer> arr){
        if(k==arr.size()) ans.add(new ArrayList<>(arr));
        else {
            int num = arr.size() == 0 ? 0 : arr.get(arr.size()-1);
            for(int i=num+1; i<=n; i++) {
                arr.add(i);
                backtrack(n, k, arr);
                arr.remove(arr.size()-1);
            }
        }
    }
}
