package leetcode.java;

import java.util.*;

class L0160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> sa = new Stack<>();
        Stack<ListNode> sb = new Stack<>();
        ListNode head = null;
        while (headA != null) {
            sa.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            sb.push(headB);
            headB = headB.next;
        }
        head = null;
        while (!sb.empty() && !sa.empty() && sa.peek() == sb.peek()) {
            head = sa.pop();
            sb.pop();
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode data1 = new ListNode();
        ListNode data2 = new ListNode();
        data1 = data1.append(5);
        data1 = data1.append(4);
        data1 = data1.append(8);
        data2 = new ListNode(1, data1);
        data1 = new ListNode(1, data1);
        data1 = data1.append(4);
        data2 = data2.append(6);
        data2 = data2.append(5);

        System.out.println(data1);
        System.out.println(data2);
        System.out.println(L0160.getIntersectionNode(data1, data2).val);

    }
}