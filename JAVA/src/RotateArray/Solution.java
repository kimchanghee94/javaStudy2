package RotateArray;

public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;

        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[end];
            nums[end] = nums[start];
            nums[start] = tmp;

            start++;
            end--;
        }
    }
}

/*
class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k%=n;
        reverse(nums,0, n-1);
        reverse(nums,0, k-1);
        reverse(nums,k, n-1);
    }

    private void reverse(int[] nums, int left, int right){
        while(left<right){
            int tmp=nums[left];
            nums[left++]=nums[right];
            nums[right--]=tmp;
        }
    }
}
*/