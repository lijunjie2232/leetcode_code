package leetcode.java;

import java.util.*;

public class L0455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0, a = 0, b = 0;
        while (a < g.length && b < s.length) {
            if (g[a] <= s[b]) {
                cnt++;
                a++;
            }
            b++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(findContentChildren(new int[] { 1, 2, 3 }, new int[] { 1, 1 }));
        System.out.println(findContentChildren(new int[] { 1, 1 }, new int[] { 1, 2, 3 }));
    }
}
