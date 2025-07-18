package FindKPairsWithSmallestSums;
import java.util.*;
public class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]+a[1]));
        for(int i=0; i<nums1.length && i<k; i++) pq.offer(new int[]{nums1[i], nums2[0], 0});
        while(ans.size() < k){
            int[] tmp = pq.poll();
            int num1 = tmp[0], num2 = tmp[1], idx = tmp[2];
            ans.add(Arrays.asList(num1, num2));
            if(idx+1 < nums2.length) pq.offer(new int[]{num1, nums2[idx+1], idx+1});
        }
        return ans;
    }
}
