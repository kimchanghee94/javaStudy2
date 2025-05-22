package MergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx = nums1.length - 1;

        while(m>0 && n>0){
            if(nums1[m-1] >= nums2[n-1]){
                nums1[idx--] = nums1[m-1];
                m--;
            }else{
                nums1[idx--] = nums2[n-1];
                n--;
            }
        }

        if(n>0){
            for(int i=0; i<n; i++){
                nums1[i] = nums2[i];
            }
        }
    }
}
