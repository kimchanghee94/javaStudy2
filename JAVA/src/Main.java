import MergeSortedArray.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1,2,3,0,0,0};
        sol.merge(nums1, 3, new int[]{2,5,6}, 3);
    }
}