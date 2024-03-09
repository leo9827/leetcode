package neetcode150.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * 20. Valid Parentheses
 * Easy.
 * 
 * Example 1:
    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c == '(' ) {
                st.push(')');
            } else if (c == '[') {
                st.push(']');
            } else if (c == '{') {
                st.push('}');
            }else if (st.isEmpty() || st.pop() != c) { // case "))"
                return false;
            }
        }
        return st.isEmpty();
    }
    public static void main(String[] args) {
        ValidParentheses v =new ValidParentheses();
        System.out.println(v.isValid("))") == true);
    }
}
