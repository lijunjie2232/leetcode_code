package leetcode.java;

import java.util.*;

public class L0076 {
    int[] windowCount;
    int[] tCount;
    int bestLeft;
    int bestRight;
    int best;
    String s;
    String t;
    int left, right, point, asic;
    char tmpC;

    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        this.bestLeft = 0;
        this.bestRight = 0;
        this.best = 1000000;
        this.tCount = new int[128];
        this.windowCount = new int[128];
        this.s = s;
        this.t = t;

        for (char c : t.toCharArray())
            this.tCount[(int) c]++;

        this.left = 0;
        this.right = 0;
        this.asic = 0;
        this.point = 0;
        while (this.point < t.length()) {
            this.asic = (int) t.charAt(this.point++);
            while (this.tCount[this.asic] > this.windowCount[this.asic] && this.right < this.s.length()) {
                tmpC = this.s.charAt(this.right++);
                this.windowCount[(int) tmpC]++;
            }
            if (this.tCount[this.asic] > this.windowCount[this.asic])
                return "";
        }
        if (this.right - this.left < this.best) {
            this.bestLeft = this.left;
            this.bestRight = this.right;
            this.best = this.right - this.left;
        }
        
        while (this.left < s.length() - t.length()) {
            this.asic = (int) s.charAt(this.left++);
            this.windowCount[this.asic]--;
            while (this.right < s.length() && this.windowCount[this.asic] < this.tCount[this.asic]) {
                this.windowCount[(int) this.s.charAt(this.right++)]++;
            }
            if (this.windowCount[this.asic] < this.tCount[this.asic])
                break;
            else if (this.right - this.left < this.best) {
                this.bestLeft = this.left;
                this.bestRight = this.right;
                this.best = this.right - this.left;
            }
        }
        return s.substring(this.bestLeft, this.bestRight);
    }

    public static void main(String[] args) {
        L0076 l0076Tset = new L0076();
        System.out.println(l0076Tset.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(l0076Tset.minWindow("a", "a"));
        System.out.println(l0076Tset.minWindow("a", "aa"));
        System.out.println(l0076Tset.minWindow("ab", "a"));
        System.out.println(l0076Tset.minWindow("ab", "b"));
        System.out.println(l0076Tset.minWindow("ab", "A"));
    }
}
