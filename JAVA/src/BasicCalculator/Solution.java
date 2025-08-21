package BasicCalculator;

import java.util.*;

public class Solution {
    public int calculate(String s) {
        int ans=0, num=0, sign=1;
        Stack<Integer> stack = new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='+'){
                ans+=sign*num;
                num=0;
                sign=1;
            }else if(c=='-'){
                ans+=sign*num;
                num=0;
                sign=-1;
            }else if(c=='('){
                stack.push(ans);
                stack.push(sign);
                ans=0;
                sign=1;
            }else if(c==')'){
                ans+=sign*num;
                num=0;
                ans*=stack.pop();
                ans+=stack.pop();
            }else if(c!=' '){
                num = num*10 + (c-'0');
            }
        }

        return ans + (sign*num);
    }
}

/*
class Solution {
    public int calculate(String s) {
        int ans=0,num=0,sign=1;
        Stack<Integer> stack=new Stack<>();
        for(char c : s.toCharArray()){
            switch(c){
                case '+'->{
                    ans+=sign*num;
                    num=0;
                    sign=1;
                }
                case '-'->{
                    ans+=sign*num;
                    num=0;
                    sign=-1;
                }
                case '('->{
                    stack.push(ans);
                    stack.push(sign);
                    ans=0;
                    sign=1;
                }
                case ')'->{
                    ans+=sign*num;
                    num=0;
                    ans*=stack.pop();
                    ans+=stack.pop();
                }
                default->{
                    if(c!=' ') num=num*10+(c-'0');
                }
            }
        }
        return ans+(sign*num);
    }
}
*/