package leetcode.java;

import java.util.*;

class L0206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode l = null, m = head, r = head.next;
        while (m != null) {
            m.next = l;
            l = m;
            m = r;
            if (r != null)
                r = r.next;
        }
        return l;
    }

    public static void main(String[] args) {
        ListNode data1 = null;
        ListNode data2 = null;
        for (int i : List.of(1, 2)) {
            data1 = new ListNode(i, data1);
        }
        for (int i : List.of(1, 2, 3, 4, 5)) {
            data2 = new ListNode(i, data2);
        }
        System.out.println(data1);
        System.out.println(L0206.reverseList(data1));
        System.out.println(data2);
        System.out.println(L0206.reverseList(data2));
    }
}