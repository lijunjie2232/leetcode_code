package leetcode.java;

import java.util.*;

public class L0113 {
    public int sum;
    public int currentSum;
    public List<List<Integer>> pathSet;
    public List<Integer> currentPath;

    public void walker(TreeNode node) {
        this.currentPath.add(node.val);
        this.currentSum += node.val;
        if (node.left == null && node.right == null) {
            if (this.currentSum == this.sum)
                this.pathSet.add(new LinkedList<>(this.currentPath));
        } else {
            if (node.left != null)
                this.walker(node.left);
            if (node.right != null)
                this.walker(node.right);
        }
        this.currentSum -= node.val;
        this.currentPath.remove(this.currentPath.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.sum = targetSum;
        this.currentSum = 0;
        this.pathSet = new LinkedList<>();
        this.currentPath = new LinkedList<>();
        if (root != null)
            this.walker(root);
        return this.pathSet;
    }
}
