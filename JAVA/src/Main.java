import 유연근무제.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };

        System.out.println(sol.solution(schedules, timelogs, 5));
    }
}