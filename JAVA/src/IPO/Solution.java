package IPO;
import java.util.*;
public class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int N = profits.length;
        int[][] projects = new int[N][2];
        for(int i=0; i<N; i++){
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }
        Arrays.sort(projects, Comparator.comparingInt(a->a[0]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0,j=0; i<k; i++){
            while(j<N && projects[j][0] <= w){
                maxHeap.offer(projects[j][1]);
                j++;
            }
            if(maxHeap.isEmpty()) break;
            w+=maxHeap.poll();
        }
        return w;
    }
}
