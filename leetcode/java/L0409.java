package leetcode.java;

import java.util.*;

public class L0409 {
    public static int longestPalindrome(String s) {
        Map<Character, Integer> cm = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (cm.containsKey(c))
                cm.put(c, cm.get(c) + 1);
            else
                cm.put(c, 1);
        }
        int count = 0, tmp = 0, flag = 0;
        for (char c : cm.keySet()) {
            tmp = cm.get(c);
            count += tmp - tmp % 2;
            flag += tmp % 2;
        }
        if (flag > 0)
            count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
        System.out.println(longestPalindrome("a"));
    }
}
