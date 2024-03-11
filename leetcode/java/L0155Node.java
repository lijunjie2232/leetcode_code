package leetcode.java;

class MinStackNode {
    public int val;
    public MinStackNode next;

    public MinStackNode() {
    }

    public MinStackNode(int val) {
        this.val = val;
    }

    public MinStackNode(int val, MinStackNode next) {
        this.val = val;
        this.next = next;
    }

}

class MinStackL0155Node {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    private MinStackNode data;
    private MinStackNode min;

    public MinStackL0155Node() {
        data = null;
        min = null;
    }

    public void push(int val) {
        this.data = new MinStackNode(val, this.data);
        if (min == null || min.val > val)
            this.min = new MinStackNode(val, this.min);
        else
            this.min = new MinStackNode(this.min.val, this.min);
    }

    public void pop() {
        this.data = this.data.next;
        this.min = this.min.next;
    }

    public int top() {
        return data == null ? null : data.val;
    }

    public int getMin() {
        return min == null ? null : min.val;
    }
}

public class L0155Node {
    public static void main(String[] args) {
        MinStackL0155Node minStack = new MinStackL0155Node();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
