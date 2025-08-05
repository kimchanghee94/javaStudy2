package GasStation;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int maxSum = 0, tank=0;
        int answer = 0;

        for(int i=0; i<gas.length; i++){
            int val = gas[i] - cost[i];
            maxSum += val;
            tank += val;

            if(tank < 0){
                answer = i+1;
                tank = 0;
            }
        }

        return maxSum < 0 ? -1 : answer;
    }
}

/*
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total=0, tank=0, start=0;
        for(int i=0; i<gas.length; i++){
            int diff=gas[i]-cost[i];
            total+=diff;
            tank+=diff;
            if(tank<0){
                start=i+1;
                tank=0;
            }
        }
        return total>=0 ? start : -1;
    }
}
*/