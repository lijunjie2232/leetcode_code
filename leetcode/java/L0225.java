package leetcode.java;

import java.util.*;

class MyStackL0225 {
    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
    private Queue<Integer> dataQueue;
    private Queue<Integer> tempQueue;

    public MyStackL0225() {
        dataQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        if (dataQueue.isEmpty())
            dataQueue.add(x);
        else {
            while (!dataQueue.isEmpty())
                tempQueue.add(dataQueue.poll());
            dataQueue.add(x);
            while (!tempQueue.isEmpty())
                dataQueue.add(tempQueue.poll());
        }
    }

    public int pop() {
        return dataQueue.isEmpty() ? null : dataQueue.poll();
    }

    public int top() {
        return dataQueue.peek();
    }

    public boolean empty() {
        return dataQueue.isEmpty();
    }
}

public class L0225 {

}
