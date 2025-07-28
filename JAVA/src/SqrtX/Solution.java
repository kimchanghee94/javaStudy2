package SqrtX;

public class Solution {
    public int mySqrt(int x) {
        int left=0, right=x, ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            long val=(long)mid*mid;
            if(val==x) return mid;

            if(val>x) right=mid-1;
            else {
                ans=mid;
                left=mid+1;
            }
        }
        return ans;
    }
}