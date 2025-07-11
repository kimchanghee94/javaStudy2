package GenerateParentheses;
import java.util.*;
public class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n*2, 0, 0, new StringBuilder());
        return ans;
    }

    private void backtrack(int n, int left, int right, StringBuilder path){
        if(n == left+right) ans.add(path.toString());
        else{
            if(left < n/2){
                path.append("(");
                backtrack(n, left+1, right, path);
                path.deleteCharAt(left+right);
            }
            if(left > right){
                path.append(")");
                backtrack(n, left, right+1, path);
                path.deleteCharAt(left+right);
            }
        }
    }
}
