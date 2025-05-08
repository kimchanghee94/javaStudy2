import 퍼즐게임챌린지.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.solution(new int[]{1, 99999, 100000, 99995},
                new int[]{9999, 9001, 9999, 9001}, 3456789012L));
    }
}