package leetcode.java;

public class L0141FSPoint {
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head, fast = head.next;
        while (fast != null) {
            if (slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next;
            fast = fast == null ? null : fast.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode data1 = new ListNode(5);
        data1 = data1.append(5);
        ListNode point = data1;
        data1 = data1.append(4);
        data1 = data1.append(8);
        point.next = data1;
        data1 = data1.append(4);
        data1 = data1.append(1);
        data1 = data1.append(3);
        data1 = data1.append(8);
        data1 = data1.append(4);
        data1 = data1.append(6);
        data1 = data1.append(5);
        data1 = data1.append(1);

        System.out.println(data1.length);
        System.out.println(L0141FSPoint.hasCycle(data1));

    }
}
