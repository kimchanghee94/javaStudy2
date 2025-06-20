package InsertInterval;

import java.util.*;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        int i=0, N=intervals.length;

        while(i<N && intervals[i][1] < newInterval[0]) ans.add(intervals[i++]);
        while(i<N && intervals[i][0] <= newInterval[1])
            newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i++][1])};
        ans.add(newInterval);
        while(i<N) ans.add(intervals[i++]);

        return ans.toArray(new int[ans.size()][]);
    }
}
