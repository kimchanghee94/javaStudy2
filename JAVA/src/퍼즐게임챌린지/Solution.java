package 퍼즐게임챌린지;

public class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        long left = 1;
        long right = limit;

        while(left < right){
            long mid = (left + right)/2;

            if(valid(diffs, times, mid, limit)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }

        return (int)left;
    }

    boolean valid(int[] diffs, int[] times, long level, long limit){
        long total = times[0];

        for(int i=1; i<diffs.length; i++){
            int diff = diffs[i];

            if(diff > level){
                total += ((long)diff-level)*((long)times[i-1]+times[i]);
            }

            total += times[i];

            if(total > limit){
                return false;
            }
        }

        return true;
    }
}
