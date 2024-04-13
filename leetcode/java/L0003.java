package leetcode.java;

import java.util.*;

class L0003 {
    private int count = 0;
    private int longest = 0;
    private int[] tongpaixu = new int[128];
    private Queue<Character> substr;

    public void push(char c) {
        while (this.tongpaixu[Integer.valueOf(c)] > 0)
            this.pop();
        this.substr.add(c);
        this.tongpaixu[Integer.valueOf(c)] += 1;
        this.count++;
        // System.out.println(count);
        if (this.longest < this.count)
            this.longest = this.count;
    }

    public void pop() {
        this.count--;
        this.tongpaixu[Integer.valueOf(substr.poll())]--;
    }

    public int lengthOfLongestSubstring(String s) {
        for (int i = 0; i < 128; i++)
            tongpaixu[i] = 0;
        this.longest = 0;
        this.count = 0;
        this.substr = new LinkedList<>();
        int right = 0;
        while (right < s.length()) {
            this.push(s.charAt(right++));
        }
        return this.longest;
    }

    public static void main(String[] args) {
        L0003 test = new L0003();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
        System.out.println(test.lengthOfLongestSubstring(" "));
    }
}