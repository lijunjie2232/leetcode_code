package leetcode.java;

import java.util.*;

class L0002 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int a = 0, b = 0;
        ListNode sum = null, head = null;
        int cnt = 0;
        while (l1 != null || l2 != null || cnt != 0) {
            a = l1 == null ? 0 : l1.val;
            b = l2 == null ? 0 : l2.val;
            cnt += a + b;
            if (sum == null) {
                head = new ListNode(cnt % 10);
                sum = head;
            } else {
                sum.next = new ListNode(cnt % 10);
                sum = sum.next;
            }
            cnt /= 10;

            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode data1 = null;
        ListNode data2 = null;
        for (int i : List.of(9, 9, 9, 9)) {
            data1 = new ListNode(i, data1);
        }
        for (int i : List.of(9, 9, 9, 9, 9, 9, 9)) {
            data2 = new ListNode(i, data2);
        }
        System.out.println(L0002.addTwoNumbers(data1, data2));
    }
}