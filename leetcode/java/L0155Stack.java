package leetcode.java;

import java.util.*;

class MinStackL0155Stack {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    private Stack<Integer> data;
    private Stack<Integer> min;

    public MinStackL0155Stack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int val) {
        this.data.add(val);
        this.min.add(min.isEmpty() || min.peek() > val ? val : min.peek());
    }

    public void pop() {
        if (data.isEmpty())
            return;
        min.pop();
        data.pop();
    }

    public int top() {
        return data.isEmpty() ? null : data.peek();
    }

    public int getMin() {
        return min.isEmpty() ? null : min.peek();
    }
}

public class L0155Stack {
    public static void main(String[] args) {
        MinStackL0155Stack minStack = new MinStackL0155Stack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
