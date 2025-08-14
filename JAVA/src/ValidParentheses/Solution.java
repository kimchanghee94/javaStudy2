package ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='[') stack.push(c);
            else if(stack.isEmpty()) return false;
            else{
                char comp=stack.pop();
                if(c==')'&&comp!='(') return false;
                else if(c=='}'&&comp!='{') return false;
                else if(c==']'&&comp!='[') return false;
            }
        }
        return stack.isEmpty();
    }
}

/*
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c== '[') stack.push(c);
            else if(stack.isEmpty()) return false;
            else if(c==')' && stack.pop()!='(') return false;
            else if(c=='}' && stack.pop()!='{') return false;
            else if(c==']' && stack.pop()!='[') return false;
        }
        return stack.isEmpty();
    }
}
*/
