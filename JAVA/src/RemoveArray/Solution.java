package RemoveArray;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}

/*
class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int num : nums) if(num!=val) nums[k++]=num;
        return k;
    }
}
*/