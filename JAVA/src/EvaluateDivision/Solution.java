package EvaluateDivision;

import java.util.*;

public class Solution {
    Set<String> flag;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i=0; i<equations.size(); i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).put(a, 1/values[i]);
        }

        int N = queries.size();
        double[] ans = new double[N];
        for(int i=0; i<N; i++){
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);

            flag = new HashSet<>();
            double result = dfs(graph, a, b, 1.0);
            ans[i] = result;
        }

        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String a, String b, Double ans){
        if(!graph.containsKey(a)) return -1.0;
        if(a.equals(b)) return ans;
        flag.add(a);
        for(String neighbor : graph.get(a).keySet()){
            if(flag.contains(neighbor)) continue;
            double val = graph.get(a).get(neighbor);
            double result = dfs(graph, neighbor, b, ans*val);
            if(result != -1.0) return result;
        }
        return -1.0;
    }
}
