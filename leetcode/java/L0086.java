package leetcode.java;

public class L0086 {

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode lt = null, gt = null, ltLeft = null, gtLeft = null, tmp = null, point = head;
        while (point != null) {
            tmp = point.next;
            if (point.val >= x) {
                if (gtLeft == null) {
                    gtLeft = point;
                    gt = gtLeft;
                } else {
                    gt.next = point;
                    gt = gt.next;
                }
                gt.next = null;
            } else {
                if (ltLeft == null) {
                    ltLeft = point;
                    lt = ltLeft;
                } else {
                    lt.next = point;
                    lt = lt.next;
                }
                lt.next = null;
            }
            point = tmp;
        }
        if (lt != null)
            lt.next = gtLeft;
        else
            ltLeft = gtLeft;
        return ltLeft;
    }

    public static void main(String[] args) {
        ListNode data1 = new ListNode(2);
        data1 = data1.append(5);
        data1 = data1.append(2);
        data1 = data1.append(3);
        data1 = data1.append(4);
        data1 = data1.append(1);

        ListNode data2 = new ListNode(2);
        data2 = data2.append(1);

        System.out.println(data1);
        System.out.println(L0086.partition(data1, 3));
        System.out.println(data2);
        System.out.println(L0086.partition(data2, 2));
    }

}
