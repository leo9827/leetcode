package neetcode150.stack;
/**
 * 150. Evaluate Reverse Polish Notation
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">evaluate-reverse-polish-notation</a>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * Example 1:
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * Example 2:
 * Input: tokens = ["4","13","5","/","+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * Example 3:
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * Output: 22
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * Constraints:
 * 1 <= tokens.length <= 104
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 中等
 * <p>
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * <p>
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 注意：
 * <p>
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * <p>
 * <p>
 * 逆波兰表达式：
 * <p>
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 */
public class EvaluateReversePolishNotation {

    Set<String> markset = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>(); // perf -> arr
        for (String token : tokens) {
            if (markset.contains(token)) {
                int ret = nums.pop();
                int cur = nums.pop();
                switch (token) {
                    case "+":
                        ret = ret + cur;
                        break;
                    case "-":
                        ret = ret - cur;
                        break;
                    case "*":
                        ret = ret * cur;
                        break;
                    case "/":
                        ret = cur / ret;
                        break;
                }
                nums.add(ret);
            } else {
                nums.add(Integer.parseInt(token));
            }
        }

       return nums.pop();
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation e = new EvaluateReversePolishNotation();

        String[] tokens = new String[]{"2", "1", "+", "3","4", "+",  "*"};
        int expect = 21;
        System.out.printf("eq:%b, ret:%d, ep:%d\n", e.evalRPN(tokens) == expect, e.evalRPN(tokens), expect);

        String[] tokens1 = new String[]{"2", "1", "+", "3", "*"};
        int expect1 = 9;
        System.out.printf("eq:%b, ret:%d, ep:%d\n", e.evalRPN(tokens1) == expect1, e.evalRPN(tokens1), expect1);

        String[] tokens2 = new String[]{"4", "13", "5", "/", "+"};
        int expect2 = 6;
        System.out.printf("eq:%b, ret:%d, ep:%d\n", e.evalRPN(tokens2) == expect2, e.evalRPN(tokens2), expect2);

        String[] tokens3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int expect3 = 22;
        System.out.printf("eq:%b, ret:%d, ep:%d\n", e.evalRPN(tokens3) == expect3, e.evalRPN(tokens3), expect3);
    }
}
