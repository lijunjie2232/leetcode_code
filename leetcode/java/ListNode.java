package leetcode.java;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode {
    public Integer val = null;
    public ListNode next = null;
    public int length = 0;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
        this.length = 1;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
        this.length = next != null ? next.length + 1 : 1;
    }

    @Override
    public String toString() {
        StringBuffer s = new StringBuffer();
        ListNode l = this;
        while (l != null) {
            // System.out.print(l.val);
            s.append(String.valueOf(l.val));
            l = l.next;
        }
        return s.toString();
    }

    public ListNode append(int data) {
        if (this.length == 0) {
            this.val = data;
            this.length = 1;
            return this;
        } else
            return new ListNode(data, this);

    }

    public int length() {
        if (this.next == null)
            return 1;
        else
            return this.next.length() + 1;
    }
}