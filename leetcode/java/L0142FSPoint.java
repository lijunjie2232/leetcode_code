package leetcode.java;

public class L0142FSPoint {
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null)
            return null;
        ListNode slow = head.next, fast = head.next.next;
        while (fast != null && fast.next != null && fast != slow) {
            slow = slow.next;
            fast = fast.next.next;
            // System.out.print(slow.val);
        }
        if (fast != slow)
            return null;
        fast = head;
        // System.out.println();
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            // System.out.print(slow.val);
        }
        // System.out.println();
        return slow;
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
        System.out.println(L0142FSPoint.detectCycle(data1).val);

    }
}
