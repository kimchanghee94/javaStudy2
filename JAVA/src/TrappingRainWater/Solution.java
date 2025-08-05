package TrappingRainWater;

public class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int len = height.length;
        int left = 0, right = len-1;
        int lH = height[left], rH = height[right];

        while(left < right){
            if(height[left] < height[right]){
                if(lH < height[left]){
                    lH = height[left];
                }else{
                    answer += (lH - height[left]);
                }
                left++;
            }else{
                if(rH < height[right]){
                    rH = height[right];
                }else{
                    answer += (rH - height[right]);
                }
                right--;
            }
        }

        return answer;
    }
}

/*
class Solution {
    public int trap(int[] height) {
        int n=height.length,ans=0,left=0,right=n-1,lH=height[left],rH=height[right];
        while(left<right){
            if(height[left]<height[right]){
                if(lH<height[left]) lH=height[left];
                else ans+=lH-height[left];
                left++;
            }else{
                if(rH<height[right]) rH=height[right];
                else ans+=rH-height[right];
                right--;
            }
        }
        return ans;
    }
}
*/