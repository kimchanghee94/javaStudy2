package InsertInterval;

import java.util.*;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int ns = newInterval[0], ne = newInterval[1];
        boolean flag = false;
        if(intervals.length == 0) return new int[][]{newInterval};
        for(int i=0; i<=intervals.length; i++){
            int[] interval;
            if(i==intervals.length){
                if(flag == true) break;
                interval = newInterval;
            }
            else if(newInterval[0] <= intervals[i][0] && flag==false){
                interval = newInterval;
                flag = true;
                i--;
            }
            else interval = intervals[i];
            if(ans.size() == 0 || ans.get(ans.size()-1)[1] < interval[0]) ans.add(interval);
            else if(ans.get(ans.size()-1)[1] >= interval[0]) ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], interval[1]);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
