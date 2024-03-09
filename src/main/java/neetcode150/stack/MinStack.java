package neetcode150.stack;
/**
 * https://leetcode.com/problems/min-stack/description/
 * 155. Min Stack
 * Medium
 * 
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

public class MinStack {

    Node head;

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val,val, null);
        } else {
            head = new Node(val,Math.min(head.min, val), head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
    class MinStack2 { 
        Node head;
        public MinStack2() {
            head = new Node(Integer.MAX_VALUE,Integer.MAX_VALUE, null);
        }
        public void push(int val) {
            head = new Node(val, Math.min(head.min, val), head);
        }
        public void pop() {
            head = head.next;
        }
        public int top() {
            return head.val;
        }
        public int getMin() {
            return head.min;
        }
    }

    class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

