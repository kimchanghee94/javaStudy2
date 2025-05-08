package 충돌위험찾기;

import java.util.*;

public class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<Integer, Map<String, Integer>> timeline = new HashMap<>();

        Map<Integer, int[]> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, points[i]);
        }

        // 각 로봇에 대해 시뮬레이션
        for (int[] route : routes) {
            int time = 0;

            // 1. 출발지 시간 0에 기록
            int[] startPoint = pointMap.get(route[0]);
            String startPos = startPoint[0] + "," + startPoint[1];
            timeline.putIfAbsent(time, new HashMap<>());
            Map<String, Integer> startMap = timeline.get(time);
            startMap.put(startPos, startMap.getOrDefault(startPos, 0) + 1);
            time++;

            // 2. 경로 이동
            for (int i = 0; i < route.length - 1; i++) {
                int[] from = pointMap.get(route[i]);
                int[] to = pointMap.get(route[i + 1]);

                List<String> path = getPath(from, to);
                for (String pos : path) {
                    timeline.putIfAbsent(time, new HashMap<>());
                    Map<String, Integer> curMap = timeline.get(time);
                    curMap.put(pos, curMap.getOrDefault(pos, 0) + 1);
                    time++;
                }
            }
        }

        // 3. 충돌 카운트
        int danger = 0;
        for (Map<String, Integer> map : timeline.values()) {
            for (int count : map.values()) {
                if (count >= 2) danger++;
            }
        }

        return danger;
    }

    // r 우선 → c 후순 최단 경로 (도착 포함됨)
    private List<String> getPath(int[] start, int[] end) {
        List<String> path = new ArrayList<>();
        int sr = start[0], sc = start[1];
        int er = end[0], ec = end[1];

        int r = sr, c = sc;

        while (r != er) {
            r += (er > r) ? 1 : -1;
            path.add(r + "," + c);
        }

        while (c != ec) {
            c += (ec > c) ? 1 : -1;
            path.add(r + "," + c);
        }

        return path;
    }
}
