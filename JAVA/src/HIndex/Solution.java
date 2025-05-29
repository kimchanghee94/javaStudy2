package HIndex;

import java.util.*;

public class Solution {
    public int hIndex(int[] citations) {
        int ans = 0;

        Integer[] arrList = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(arrList, Collections.reverseOrder());

        for(int i=0; i<arrList.length; i++){
            if(i+1 > arrList[i]){
                ans = i+1;
            }
        }

        return ans;
    }
}
