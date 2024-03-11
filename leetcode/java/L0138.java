package leetcode.java;

import java.util.*;

class NodeL0138 {
    int val;
    NodeL0138 next;
    NodeL0138 random;

    public NodeL0138(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class L0138 {

    public static NodeL0138 linkNode(NodeL0138 head, int id, NodeL0138 targetNode) {
        NodeL0138 p = head;
        while (id > 0)
            p = p.next;
        targetNode.random = p;
        return head;
    }

    public static NodeL0138 copyRandomList(NodeL0138 head) {
        Map<NodeL0138, Integer> nodeMap = new HashMap<>();
        NodeL0138 p = head;
        int id = 0;
        while (p != null) {
            nodeMap.put(p, id);
            id++;
            p = p.next;
        }

        NodeL0138 newList = null, np = null;
        for (p = head; p != null; p = p.next) {
            if (np == null) {
                newList = new NodeL0138(p.val);
                np = newList;
            } else {
                np.next = new NodeL0138(p.val);
                np = np.next;
            }
            np.next = null;
        }
        // NodeL0138 oldPoint = head, newPoint = newList;

        // while (oldPoint != null) {
        // if (oldPoint.random != null) {
        // id = nodeMap.get(oldPoint.random);
        // NodeL0138 p = head;
        // while (id > 0)
        // p = p.next;
        // newPoint.random = p;
        // } else
        // newPoint.random = null;
        // oldPoint = oldPoint.next;
        // newPoint = newPoint.next;
        // }

        return newList;
    }

}
