package grind75;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false; // if s length is odd then may be it is not closed correctly
        }
        char[] stack = new char[s.length()];
        int head = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack[head++] = ')';
                    break;
                case '{':
                    stack[head++] = '}';
                    break;
                case '[':
                    stack[head++] = ']';
                    break;
                default:
                    if (head == 0 || stack[--head] != c) {
                        return false;
                    }
                    break;
            }
        }
        return head == 0;
    }
}

class Solution {
    public boolean isValid(String s) {
        Map<String, String> map = new HashMap<>(4);
        map.put("(", ")");
        map.put("[", "]");
        map.put("{", "}");
        Stack<String> stk = new Stack<>();

        for (var i : s.toCharArray()) {
            var item = Character.toString(i);
            if (map.containsKey(item)) {
                stk.push(item);
            } else if (stk.empty()) {
                return false;
            } else if (item.equals(map.get(stk.peek()))) {
                stk.pop();
            } else {
                return false;
            }
        }
        return stk.empty();
    }
}
