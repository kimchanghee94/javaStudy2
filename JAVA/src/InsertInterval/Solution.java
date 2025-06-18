package InsertInterval;

import java.util.*;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // 1. newInterval보다 앞에 있는 interval은 그냥 추가
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. 겹치는 interval들과 병합
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // 병합된 interval 추가

        // 3. newInterval보다 뒤에 있는 interval 추가
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result;
    }
}
