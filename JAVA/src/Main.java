import 완전범죄.FullCrime;

public class Main {

    public static void main(String[] args) {
        FullCrime fc = new FullCrime();

        int[][] input = new int[][]{{1, 2}, {2, 3}};

        System.out.println(fc.solution(input,4,4));
    }
}