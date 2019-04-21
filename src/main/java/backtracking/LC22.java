package backtracking;

import java.util.LinkedList;
import java.util.List;

public class LC22 {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
     *
     * For example, given n = 3, a solution set is:
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * @param n
     * @return
     */

    public List<String> generateParenthesis(int n) {
        List<String> list = new LinkedList<>();
        String builder = new String();
        bc(list, builder, n, 0, 0);
        return list;
    }

    /**
     * Actually this is not a valid back tracking solution, because
     * @param list
     * @param builder
     * @param n
     * @param open
     * @param close
     */

    private void bc(List<String> list, String builder, int n, int open, int close) {
        if(builder.length() == n * 2) {
            list.add(builder);
        }

        if(open < n) {
            bc(list, builder + '(', n, open + 1, close);
        }

        if(close < open) {
            bc(list, builder + ')', n, open, close + 1);
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LC22().generateParenthesis(4);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
