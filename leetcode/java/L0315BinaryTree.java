package leetcode.java;

import java.util.*;
import java.util.stream.Collectors;

class BSTNode {
    int val;
    int countLeft;
    BSTNode left;
    BSTNode right;

    BSTNode(int v) {
        this.val = v;
        this.countLeft = 0;
        this.left = null;
        this.right = null;
    }
}

public class L0315BinaryTree {
    BSTNode root;

    public int insertWalker(BSTNode root, BSTNode node, int count_small) {
        if (node.val <= root.val) {
            root.countLeft++;
            if (root.left == null)
                root.left = node;
            else
                return this.insertWalker(root.left, node, count_small);
        } else {
            count_small += root.countLeft + 1;
            if (root.right == null)
                root.right = node;
            else
                return this.insertWalker(root.right, node, count_small);
        }
        return count_small;
    }

    public List<Integer> countSmaller(int[] nums) {
        this.root = null;
        Integer[] count = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            BSTNode node = new BSTNode(nums[i]);
            if (this.root == null) {
                this.root = node;
                count[i] = 0;
            } else
                count[i] = this.insertWalker(this.root, node, 0);
        }
        List<Integer> countList = Arrays.asList(count);
        return countList;
    }
}
