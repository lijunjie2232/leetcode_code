package leetcode.java;

import java.util.*;

public class L0022 {
    public List<String> subsets;
    private StringBuffer str;
    public int left;
    public int right;
    public int target;

    public void strWalker() {
        if (this.left == this.target && this.right == this.target) {
            this.subsets.add(new String(this.str));
            return;
        }
        if (this.left > this.right && this.right < this.target) {
            this.str.append(')');
            this.right++;
            this.strWalker();
            this.right--;
            this.str.deleteCharAt(this.str.length() - 1);
        }
        if (this.left < this.target) {
            this.str.append('(');
            this.left++;
            this.strWalker();
            this.left--;
            this.str.deleteCharAt(this.str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        this.target = n;
        this.left = 0;
        this.right = 0;
        this.str = new StringBuffer();
        this.subsets = new LinkedList<>();
        this.strWalker();
        return this.subsets;
    }

    public static void main(String[] args) {
        L0022 test = new L0022();
        System.out.println(test.generateParenthesis(3));
        System.out.println(test.generateParenthesis(8));

    }
}
