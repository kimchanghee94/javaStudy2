package CourseSchedule2;

import java.util.*;

public class Solution {
    int[] flag;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int[] pre : prerequisites){
            graph.putIfAbsent(pre[1], new ArrayList<>());
            graph.get(pre[1]).add(pre[0]);
        }

        List<Integer> ans = new ArrayList<>();
        flag = new int[numCourses];
        for(int i=0; i<numCourses; i++) if(cycle(graph, ans, i)) return new int[]{};
        int[] result = new int[ans.size()];
        for(int i=0; i<ans.size(); i++) result[i]=ans.get(ans.size()-i-1);
        return result;
    }

    private boolean cycle(Map<Integer, List<Integer>> graph, List<Integer> ans, int strt){
        if(flag[strt]==1) return true;
        if(flag[strt]==2) return false;
        flag[strt]=1;
        if(graph.containsKey(strt)) for(int next : graph.get(strt)) if(cycle(graph, ans, next)) return true;
        flag[strt]=2;
        ans.add(strt);
        return false;
    }
}