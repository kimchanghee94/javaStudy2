package MinimumNumberOfArrowsToBurstBalloons;

import java.util.*;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int ans=1,e=points[0][1];
        for(int[] point:points){
            if(e<point[0]){
                ans++;
                e=point[1];
            }
        }
        return ans;
    }
}

/*
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[1],b[1]));
        int ans=1,e=points[0][1];
        for(int[] point:points){
            if(e<point[0]){
                ans++;
                e=point[1];
            }
        }
        return ans;
    }
}
*/