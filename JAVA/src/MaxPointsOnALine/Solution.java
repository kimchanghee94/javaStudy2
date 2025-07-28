package MaxPointsOnALine;

public class Solution {
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n<=2) return n;
        int ans=0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int count=2;
                int dx=points[i][0]-points[j][0];
                int dy=points[i][1]-points[j][1];
                for(int k=j+1; k<n; k++){
                    int dx2=points[j][0]-points[k][0];
                    int dy2=points[j][1]-points[k][1];
                    if(dx2*dy==dx*dy2) count++;
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}