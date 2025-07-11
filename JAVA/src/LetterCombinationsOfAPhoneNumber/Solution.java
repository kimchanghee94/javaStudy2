package LetterCombinationsOfAPhoneNumber;
import java.util.*;
public class Solution {
    List<String> ans = new ArrayList<>();
    Map<Character, char[]> map = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        map.put('2', new char[]{'a','b','c'});map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});map.put('9', new char[]{'w','x','y','z'});

        backtrack(digits, 0, new StringBuilder());
        return ans;
    }
    private void backtrack(String digits, int cnt, StringBuilder path){
        if(digits.length() == cnt) {
            ans.add(path.toString());
            return;
        }
        char[] arr = map.get(digits.charAt(cnt));
        for(int i=0; i<arr.length; i++) {
            path.append(arr[i]);
            backtrack(digits, cnt+1, path);
            path.deleteCharAt(cnt);
        }
    }
}
