package neetcode150.stack;

import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/implement-queue-using-stacks>232. Implement Queue using Stacks</a>
 * Easy
 */
public class ImplementQueueUsingStacks {
   static class MyQueue {
        Stack<Integer> in = new Stack<>();
        Stack<Integer> out = new Stack<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            peek();
            return out.pop();
        }

        public int peek() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }
}
