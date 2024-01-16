package neetcode150.stack;

import java.util.*;

/**
 * 22. Generate Parentheses
 * Medium
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 * <p>
 * Input: n = 1
 * Output: ["()"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {

        List<String> results = new ArrayList<>();
        bp(results, "", 0, 0, n);

        return results;
    }

    /*
    an example to understand this solution:
    (
    ((

    (((
    ((()
    ((())
    ((()))

    (()
    (()(
    (()()
    (()())

    (())
    (())(
    (())()

    ()
    ()(
    ()((
    ()(()
    ()(())

    ()()
    ()()(
    ()()()
     */

    private void bp(List<String> results, String cur, int left, int right, int max) {
        if (cur.length() == max * 2) {
            results.add(cur);
            return;
        }

        if (left < max) {
            bp(results, cur+"(", left+1, right, max);
        }

        if (right < left) {
            bp(results, cur+")", left, right+1, max);
        }

    }

    public static void main(String[] args) {
        int n1 = 3;
        List<String> l1 = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        GenerateParentheses g = new GenerateParentheses();
        System.out.printf("g:%s, ep:%s\n", g.generateParenthesis(n1), l1);

        int n2 = 1;
        List<String> l2 = Arrays.asList("()");
        System.out.printf("g:%s, ep:%s\n", g.generateParenthesis(n2), l2);
    }
}
