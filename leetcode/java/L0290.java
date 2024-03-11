package leetcode.java;

import java.util.*;

public class L0290 {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> cm = new HashMap<>();
        Map<String, Character> cn = new HashMap<>();
        String[] items = s.split(" ");
        char[] patterns = pattern.toCharArray();
        if (patterns.length != items.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (!cm.containsKey(patterns[i]))
                cm.put(patterns[i], items[i]);
            else if (!cm.get(patterns[i]).equals(items[i]))
                return false;
            if (!cn.containsKey(items[i]))
                cn.put(items[i], patterns[i]);
            else if (!cn.get(items[i]).equals(patterns[i]))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
        System.out.println(wordPattern("abba", "dog cat cat fish"));
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
