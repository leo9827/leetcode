package blind75.heap;

import java.util.Stack;

public class ImplementQueueusingStacks {

}

// queue FIFO
class MyQueue {

    Stack<Integer> push = new Stack<>();
    Stack<Integer> pop = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        if (push.empty())
            while (!pop.empty())
                push.push(pop.pop());
        push.push(x);
    }

    public int pop() {
        peek();
        return pop.pop();
    }

    public int peek() {
        if (pop.empty())
            while (!push.empty())
                pop.push(push.pop());
        return pop.peek();
    }

    public boolean empty() {
        return pop.isEmpty() && push.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
