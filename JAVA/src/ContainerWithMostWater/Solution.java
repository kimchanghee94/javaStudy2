package ContainerWithMostWater;

public class Solution {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int ans = 0;

        while(left < right){
            int store = Math.min(height[right], height[left]);
            ans = Math.max(ans, store * (right-left));

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }

        return ans;
    }
}

/*
class Solution {
    public int maxArea(int[] height) {
        int ans=0, l=0, r=height.length-1;
        while(l<r){
            ans = Math.max(ans, Math.min(height[l],height[r])*(r-l));
            if(height[l]<height[r]) l++;
            else r--;
        }
        return ans;
    }
}
*/