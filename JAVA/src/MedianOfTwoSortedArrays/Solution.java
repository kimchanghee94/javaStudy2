package MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int m=nums1.length,n=nums2.length;
        int totLen=(m+n+1)/2;
        int l=0,r=m;
        while(l<=r){
            int am=(l+r)/2, bm=totLen-am;
            int al=(am==0)?Integer.MIN_VALUE:nums1[am-1];
            int ar=(am==m)?Integer.MAX_VALUE:nums1[am];
            int bl=(bm==0)?Integer.MIN_VALUE:nums2[bm-1];
            int br=(bm==n)?Integer.MAX_VALUE:nums2[bm];
            if(al<=br&&bl<=ar){
                if((m+n)%2==1) return Math.max(al,bl);
                return (Math.max(al,bl)+Math.min(ar,br))/2.0;
            }else if(al>br) r=am-1;
            else l=am+1;
        }
        return -1.0;
    }
}