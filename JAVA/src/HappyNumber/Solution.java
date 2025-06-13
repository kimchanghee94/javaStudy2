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
