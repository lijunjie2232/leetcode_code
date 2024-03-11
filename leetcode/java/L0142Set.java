package leetcode.java;

import java.util.*;

public class L0142Set {
    public static ListNode detectCycle(ListNode head) {
        if (head == null)
            return head;
        Set<ListNode> cache = new HashSet<>();
        ListNode point = head;
        while (point != null) {
            System.out.println(point.val);
            if (cache.contains(point))
                return point;
            else
                cache.add(point);
            point = point.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode data1 = new ListNode(5);
        data1 = data1.append(5);
        ListNode point = data1;
        data1 = data1.append(4);
        data1 = data1.append(8);
        data1 = data1.append(4);
        data1 = data1.append(1);
        data1 = data1.append(3);
        data1 = data1.append(8);
        data1 = data1.append(4);
        point.next = data1;
        data1 = data1.append(6);
        data1 = data1.append(5);
        data1 = data1.append(1);

        System.out.println(data1.length);
        System.out.println(L0142Set.detectCycle(data1).val);

    }
}
