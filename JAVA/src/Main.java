import 지폐접기.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] wallet = {30, 15};
        int[] bill = {26, 17};

        System.out.println(sol.solution(wallet, bill));
    }
}