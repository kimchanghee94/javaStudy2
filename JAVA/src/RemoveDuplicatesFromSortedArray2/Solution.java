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
        int k=1, dup=0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]!=nums[i]) {
                nums[k++]=nums[i];
                dup=0;
            }
            else if(nums[i-1]==nums[i] && dup<1){
                nums[k++]=nums[i];
                dup++;
            }
        }
        return k;
    }
}
*/