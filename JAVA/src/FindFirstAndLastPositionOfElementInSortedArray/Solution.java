package FindFirstAndLastPositionOfElementInSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l=find(nums,target,true);
        int r=find(nums,target,false);
        return new int[]{l,r};
    }
    private int find(int[] nums, int target, boolean dir){
        int l=0, r=nums.length-1, result=-1;
        while(l<=r){
            int m=(l+r)/2;
            if(nums[m]==target){
                result=m;
                if(dir) r=m-1;
                else l=m+1;
            }
            else if(nums[m]<target) l=m+1;
            else r=m-1;
        }
        return result;
    }
}