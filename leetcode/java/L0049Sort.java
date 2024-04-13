package leetcode.java;

import java.util.*;

public class L0049Sort {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String strSorted = new String(strArr);
            if (groups.keySet().contains(strSorted))
                groups.get(strSorted).add(str);
            else {
                List<String> group = new LinkedList<String>();
                group.add(str);
                groups.put(strSorted, group);
            }
        }
        List<List<String>> resultList = new LinkedList<>();
        for (Map.Entry<String, List<String>> entry : groups.entrySet()) {
            resultList.add(entry.getValue());
        }
        return resultList;
    }

    public static void main(String[] args) {
        String[] data1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(L0049Sort.groupAnagrams(data1));
        String[] data2 = { "" };
        System.out.println(L0049Sort.groupAnagrams(data2));
        String[] data3 = { "a" };
        System.out.println(L0049Sort.groupAnagrams(data3));
        String[] data4 = { "", "" };
        System.out.println(L0049Sort.groupAnagrams(data4));
    }
}
