package CourseSchedule;

import java.util.*;

public class Solution {
    int[] flag;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] pre : prerequisites){
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
        }

        flag = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(cycle(graph, i)) return false;
        }
        return true;
    }

    private boolean cycle(Map<Integer, List<Integer>> graph, int strt){
        if(flag[strt] == 1) return true;
        if(flag[strt] == 2) return false;

        flag[strt] = 1;
        if(graph.containsKey(strt)) for(int next : graph.get(strt)) if(cycle(graph, next)) return true;
        flag[strt] = 2;
        return false;
    }
}