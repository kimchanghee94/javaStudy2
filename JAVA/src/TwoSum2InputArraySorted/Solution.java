package TwoSum2InputArraySorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0, right=numbers.length-1;

        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
                return new int[]{left+1, right+1};
            }else if(sum < target){
                left++;
            }else{
                right--;
            }
        }

        return new int[]{left+1, right+1};
    }
}

/*
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l=0, r=numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]==target) break;
            else if(numbers[l]+numbers[r]<target) l++;
            else r--;
        }
        return new int[]{l+1, r+1};
    }
}
*/