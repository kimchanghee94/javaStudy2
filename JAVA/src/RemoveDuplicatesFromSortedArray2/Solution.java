package RemoveDuplicatesFromSortedArray2;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;

        for(int i=1, dup=0; i<nums.length; i++){
            if(dup == 0 && nums[k] == nums[i]){
                dup++;
                nums[++k] = nums[i];
            }else if(nums[k] != nums[i]){
                dup = 0;
                nums[++k] = nums[i];
            }
        }

        return k+1;
    }
}

/*
class Solution {
    public int removeDuplicates(int[] nums) {
        int k=0;
        for(int num : nums) if(k<2 || nums[k-2]!=num) nums[k++]=num;
        return k;
    }
}
*/