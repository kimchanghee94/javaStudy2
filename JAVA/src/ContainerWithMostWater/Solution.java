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
