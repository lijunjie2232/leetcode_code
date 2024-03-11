package leetcode.java;

public class L0114 {
    public TreeNode head, point;

    public void preorder(TreeNode root) {
        if (root == null)
            return;
        // System.out.println(root.val);
        TreeNode l = root.left;
        TreeNode r = root.right;
        if (this.point != root) {
            root.left = null;
            root.right = null;
            this.point.right = root;
            this.point = root;
        }
        preorder(l);
        preorder(r);
    }

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        this.head = root;
        this.point = root;
        this.preorder(root);
        root.left = null;
    }

    public static void main(String[] args) {

        TreeNode root = TreeNode.mkTree("[3,5,1,6,2,0,8,null,null,7,4]");
        L0114 test = new L0114();
        test.flatten(root);
        System.out.println(root);
    }
}
