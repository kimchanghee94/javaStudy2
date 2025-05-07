import 비밀코드해독.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] q = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {3, 7, 8, 9, 10},
                {2, 5, 7, 9, 10},
                {3, 4, 5, 6, 7}};
        int[] ans = new int[]{2, 3, 4, 3, 3};

        System.out.println(sol.solution(10, q, ans));
    }
}