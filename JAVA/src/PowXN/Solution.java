package PowXN;

public class Solution {
    public double myPow(double x, int n) {
        if(n<0){
            x=1/x;
            n=-n;
        }
        return dfs(x, n);
    }

    private double dfs(double x, long n){
        if(n==0) return 1.0;
        double mid=dfs(x, n/2);
        if(n%2==0) return mid*mid;
        else return mid*mid*x;
    }
}