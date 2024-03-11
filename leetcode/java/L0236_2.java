package leetcode.java;

public class L0236_2 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode ls = lowestCommonAncestor(root.left, p, q);
        TreeNode rs = lowestCommonAncestor(root.right, p, q);

        if (ls != null && rs != null)
            return root;
        else
            return ls != null ? ls : rs;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.mkTree("[3,5,1,6,2,0,8,null,null,7,4]");
        L0236_2 test = new L0236_2();
        System.out.println(test.lowestCommonAncestor(root, root.left, root.right));
    }
}
