import 충돌위험찾기.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] arr1 = {
                {3, 2},
                {6, 4},
                {4, 7},
                {1, 4}
        };

        int[][] arr2 = {
                {4, 2},
                {1, 3},
                {2, 4}
        };

        System.out.println(sol.solution(arr1, arr2));
    }
}