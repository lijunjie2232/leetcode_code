package leetcode.java;

import java.util.*;

public class L0199 {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        TreeNode[] q = new TreeNode[100];
        q[0] = root;
        int point = 0, length = 1, last = 0;
        while (point < length) {
            if (q[point].left != null)
                q[length++] = q[point].left;
            if (q[point].right != null)
                q[length++] = q[point].right;
            if (point == last) {
                result.add(q[point].val);
                last = length - 1;
            }
            point++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode node;
        node = TreeNode.mkTree("[1,2,3,null,5,null,4]");
        System.out.println(L0199.rightSideView(node));
        node = TreeNode.mkTree("[1,null,3]");
        System.out.println(L0199.rightSideView(node));
    }
}
