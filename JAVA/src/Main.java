import 지게차와크레인.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

//        int[][] input = new int[]{{},{}};
//        int[] input = new int[]{};
        String[] a = new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] b = new String[]{"A", "BB", "A"};

        System.out.println(sol.solution(a,b));
    }
}