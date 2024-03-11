package leetcode.java;

import java.util.*;

class L0092 {
    public static ListNode reverseList(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right)
            return head;
        ListNode preHead = new ListNode(0, head);
        ListNode l = preHead, m = head, r = null;
        for (int i = left - 1; i > 0; i--)
            l = l.next;
        ListNode leftOutNode = l;
        l = l.next;// forward into picee
        ListNode rightInNode = l;
        m = l.next;
        r = m.next;
        for (int i = right - left; i > 0; i--) {
            if (m == null)
                break;
            m.next = l;
            l = m;
            m = r;
            if (r != null)
                r = r.next;
        }
        leftOutNode.next = l;
        rightInNode.next = m;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode data1 = null;
        ListNode data2 = null;
        ListNode data3 = null;
        for (int i : List.of(5)) {
            data1 = new ListNode(i, data1);
        }
        for (int i : List.of(5, 4, 3, 2, 1)) {
            data2 = new ListNode(i, data2);
        }
        for (int i : List.of(5, 3)) {
            data3 = new ListNode(i, data3);
        }
        System.out.println(data1);
        System.out.println(L0092.reverseList(data1, 1, 1));
        System.out.println(data2);
        System.out.println(L0092.reverseList(data2, 2, 4));
        System.out.println(data3);
        System.out.println(L0092.reverseList(data3, 1, 2));
    }
}