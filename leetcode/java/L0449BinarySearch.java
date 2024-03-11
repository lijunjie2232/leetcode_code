package leetcode.java;

public class L0449BinarySearch {
    StringBuffer sb;

    public void treeWalker(TreeNode root) {
        if (root == null)
            return;
        // System.out.println(root.val);
        this.sb.append(String.format("%d,", root.val));
        this.treeWalker(root.left);
        this.treeWalker(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        sb = new StringBuffer();
        treeWalker(root);
        return this.sb.toString();
    }

    public void insertTreeNode(TreeNode root, TreeNode t) {
        TreeNode point = root;
        // System.out.println(t.val);
        while (point != null)
            if (t.val < point.val)
                if (point.left == null) {
                    point.left = t;
                    break;
                } else
                    point = point.left;
            else if (point.right == null) {
                point.right = t;
                break;
            } else
                point = point.right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;
        TreeNode root = null;
        String[] vals = data.split(",");
        for (String val : vals)
            if (root == null)
                root = new TreeNode(Integer.valueOf(val));
            else
                insertTreeNode(root, new TreeNode(Integer.valueOf(val)));

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.mkTree("[2,1,3]");
        L0449BinarySearch ser = new L0449BinarySearch();
        L0449BinarySearch deser = new L0449BinarySearch();
        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);
        System.out.println(ans);
    }
}
