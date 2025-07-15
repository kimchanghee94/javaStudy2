package SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int min = nums[0];
        int l = 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<min){
                min=nums[i];l=i;
            }
        }
        int r = l+nums.length-1;

        while(l<=r){
            int mid = (l+r)/2;
            if(nums[mid%nums.length]==target) return mid%nums.length;
            if(nums[mid%nums.length]<target) l=mid+1;
            else r=mid-1;
        }
        return -1;
    }
}