package leetcode.java;

class L0160FSPoint {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
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
        System.out.println(L0160FSPoint.getIntersectionNode(data1, data2).val);

    }
}