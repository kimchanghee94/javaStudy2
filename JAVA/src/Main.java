import TextJustification.Solution;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(
                sol.fullJustify(
                        new String[]{"This", "is", "an", "example",
                                "of", "text", "justification."}
                , 16));
    }
}