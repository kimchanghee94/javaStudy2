package MinimumGeneticMutation;

import java.util.*;

public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, List<String>> graph = new HashMap<>();
        List<String> nodes = new ArrayList<>(Arrays.asList(bank));
        if(!nodes.contains(startGene)) nodes.add(startGene);
        for(String str1 : nodes) for(String str2 : nodes) if(neighborChk(str1, str2)) graph.computeIfAbsent(str1, k->new ArrayList<>()).add(str2);

        Set<String> flag = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startGene);
        flag.add(startGene);
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String node = q.poll();
                if(node.equals(endGene)) return ans;
                List<String> neighbors = graph.getOrDefault(node, new ArrayList<>());
                for(String neighbor : neighbors){
                    if(flag.contains(neighbor)) continue;
                    q.offer(neighbor);
                    flag.add(neighbor);
                }
            }
            ans++;
        }
        return -1;
    }

    private boolean neighborChk(String str1, String str2){
        int cnt = 0;
        for(int i=0; i<str1.length(); i++) if(str1.charAt(i) != str2.charAt(i)) cnt++;
        return cnt==1;
    }
}
