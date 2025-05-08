package 충돌위험찾기;

import java.util.*;

public class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        Map<Integer, Map<String, Integer>> map = new HashMap<>();

        for(int[] route : routes){
            int time = 0;
            int si = points[route[0]-1][0];
            int sj = points[route[0]-1][1];

            map.putIfAbsent(time, new HashMap<>());
            Map<String, Integer> tmp = map.get(time);
            tmp.put(si + "," + sj, tmp.getOrDefault(si+","+sj,0) + 1);

            for(int i=1; i<route.length; i++){
                int fi = points[route[i-1]-1][0], fj = points[route[i-1]-1][1];
                int ni = points[route[i]-1][0], nj = points[route[i]-1][1];

                List<String> paths = getPath(fi,fj,ni,nj);
                for(String path : paths){
                    time++;
                    map.putIfAbsent(time, new HashMap<>());
                    tmp = map.get(time);
                    tmp.put(path, tmp.getOrDefault(path, 0) + 1);
                }
            }

        }

        for(Map<String, Integer> map2 : map.values()){
            for(int cnt : map2.values()){
                if(cnt >= 2){
                    answer++;
                }
            }
        }

        return answer;
    }

    List<String> getPath(int fi, int fj, int ni, int nj){
        List<String> paths = new ArrayList<>();

        while(fi != ni){
            fi += fi < ni ? 1 : -1;
            paths.add(fi + "," + fj);
        }

        while(fj != nj){
            fj += fj < nj ? 1 : -1;
            paths.add(fi + "," + fj);
        }

        return paths;
    }
}
