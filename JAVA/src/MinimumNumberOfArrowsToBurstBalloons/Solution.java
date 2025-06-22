package MinimumNumberOfArrowsToBurstBalloons;

import java.util.*;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        for(int[] point:points){
            if(ans.size()==0||ans.get(ans.size()-1)[1] < point[0]) ans.add(point);
            else ans.get(ans.size()-1)[1]=Math.min(point[1], ans.get(ans.size()-1)[1]);
        }
        return ans.size();
    }
}
