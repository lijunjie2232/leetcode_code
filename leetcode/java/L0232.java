package leetcode.java;

import java.util.*;

class MyQueueL0232 {
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    private Stack<Integer> stackl, stackr;

    public MyQueueL0232() {
        stackl = new Stack<>();
        stackr = new Stack<>();
    }

    public void push(int x) {
        stackl.add(x);
    }

    public int pop() {
        if (stackr.isEmpty())
            while (!stackl.empty())
                stackr.add(stackl.pop());
        return stackr.isEmpty() ? null : stackr.pop();
    }

    public int peek() {
        if (stackr.isEmpty())
            while (!stackl.empty())
                stackr.add(stackl.pop());
        return stackr.isEmpty() ? null : stackr.peek();
    }

    public boolean empty() {
        return stackl.isEmpty() && stackr.isEmpty();
    }
}

public class L0232 {
    public static void main(String[] args) {
        MyQueueL0232 q = new MyQueueL0232();
        q.push(3);
        q.push(2);
        q.push(7);
        q.push(4);
        q.push(2);
        q.push(9);
        while (!q.empty()) {
            System.out.println(q.pop());
        }
    }
}
