package HIndex;

import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int ans = 0;

        for(int i=0; i<n; i++){
            int h = n-i;
            if(citations[i] >= h){
                ans = h;
                break;
            }
        }

        return ans;
    }
}
