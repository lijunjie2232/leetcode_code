package leetcode.java;

import java.util.*;

public class L0021 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode point = head;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                point.next = list2;
                point = list2;
                list2 = list2.next;
            } else {
                point.next = list1;
                point = list1;
                list1 = list1.next;
            }
        }
        while (list1 != null) {
            point.next = list1;
            point = list1;
            list1 = list1.next;
        }
        while (list2 != null) {
            point.next = list2;
            point = list2;
            list2 = list2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode data1 = null;
        ListNode data2 = null;
        ListNode data3 = null;
        for (int i : List.of(0)) {
            data1 = new ListNode(i, data1);
        }
        for (int i : List.of(9, 8, 5, 2)) {
            data2 = new ListNode(i, data2);
        }
        for (int i : List.of(7, 4, 1)) {
            data3 = new ListNode(i, data3);
        }
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
        System.out.println(L0021.mergeTwoLists(data2, data3));
    }
}
