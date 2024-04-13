package leetcode.java;

import java.util.*;

public class L0049 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charSet = new HashMap<>();
            for (char c : str.toCharArray())
                charSet.put(c, charSet.keySet().contains(c) ? charSet.get(c) + 1 : 1);
            if (groups.keySet().contains(charSet))
                groups.get(charSet).add(str);
            else {
                List<String> group = new LinkedList<String>();
                group.add(str);
                groups.put(charSet, group);
            }
        }
        List<List<String>> resultList = new LinkedList<>();
        for (Map.Entry<Map<Character, Integer>, List<String>> entry : groups.entrySet()) {
            resultList.add(entry.getValue());
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] data1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(L0049.groupAnagrams(data1));
        String[] data2 = { "" };
        System.out.println(L0049.groupAnagrams(data2));
        String[] data3 = { "a" };
        System.out.println(L0049.groupAnagrams(data3));
        String[] data4 = { "", "" };
        System.out.println(L0049.groupAnagrams(data4));
    }
}
