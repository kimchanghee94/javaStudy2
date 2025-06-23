package EvaluateReversePolishNotation;

import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(String token : tokens){
            if(token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")){
                int b=s.pop();
                int a=s.pop();
                switch(token){
                    case "+" -> s.push(a+b);
                    case "-" -> s.push(a-b);
                    case "*" -> s.push(a*b);
                    case "/" -> s.push(a/b);
                }
            }else s.push(Integer.valueOf(token));
        }

        return s.pop();
    }
}
