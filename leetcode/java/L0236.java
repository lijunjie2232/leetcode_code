package leetcode.java;

import java.util.*;

public class L0236 {
    public List<TreeNode> pathNode;

    public boolean bfs(TreeNode root, TreeNode target) {
        this.pathNode.add(root);
        if (root == target)
            return true;
        else {
            if (root.left != null && this.bfs(root.left, target))
                return true;
            else if (root.right != null && this.bfs(root.right, target))
                return true;
            else {
                this.pathNode.remove(this.pathNode.size() - 1);
                return false;
            }
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.pathNode = new LinkedList<>();
        this.bfs(root, p);
        List<TreeNode> pPath = this.pathNode;
        this.pathNode = new LinkedList<>();
        this.bfs(root, q);
        List<TreeNode> qPath = this.pathNode;
        int size = qPath.size() < pPath.size() ? qPath.size() : pPath.size();
        int point = 0;
        while (point < size && qPath.get(point) == pPath.get(point))
            point++;
        return pPath.get(point - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.mkTree("[3,5,1,6,2,0,8,null,null,7,4]");
        L0236 test = new L0236();
        System.out.println(test.lowestCommonAncestor(root, root.left, root.right));
    }
}
