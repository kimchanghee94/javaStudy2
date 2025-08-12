package HappyNumber;

import java.util.*;

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)){
            set.add(n);
            int sum=0;
            while(n!=0){
                int val = n%10;
                sum += val*val;
                n/=10;
            }
            n=sum;
        }
        return n==1;
    }
}

/*
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)){
            set.add(n);
            n=chk(n);
        }
        return n==1;
    }

    private int chk(int n){
        int total=0;
        while(n>0){
            int a=n%10;
            total+=a*a;
            n/=10;
        }
        return total;
    }
}
*/