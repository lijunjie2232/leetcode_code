package leetcode.java;

import java.util.*;

public class L0187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> charSet = new HashSet<>();
        int r = 10;
        while (r <= s.length()) {
            String substring = new String(s.substring(r - 10, r));
            if (charSet.contains(substring))
                result.add(substring);
            else
                charSet.add(substring);
            r++;
        }
        // List<String> resultList = new LinkedList<>();
        // for (String str : result)
        //     resultList.add(str);
        // return resultList;
        return new ArrayList(result);
    }

    public static void main(String[] args) {
        System.out.println(L0187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(L0187.findRepeatedDnaSequences("AAAAAAAAAAAAA"));
        System.out.println(L0187.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
