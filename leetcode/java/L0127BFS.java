package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L0127BFS {

    public boolean matchConv(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int purpose = wordList.indexOf(endWord);
        if (purpose < 0)
            return 0;
        wordList.add(beginWord);
        int[][] m = new int[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList.size(); i++)
            for (int j = 0; j < i; j++) {
                if (this.matchConv(wordList.get(i), wordList.get(j))) {
                    m[i][j] = 1;
                    m[j][i] = 1;
                }
            }
        Queue<Integer> q = new LinkedList<>();
        q.add(wordList.size() - 1);
        // int fl = q.peek(), fr = 0;
        int count = q.size();
        int coast = 1;
        while (!q.isEmpty()) {
            for (int i = 0; i < m.length; i++)
                if (m[q.peek()][i] == 1) {
                    if (i == purpose)
                        return coast + 1;
                    m[q.peek()][i] = 0;
                    m[i][q.peek()] = 0;
                    q.add(i);
                    // fr = i;
                }
            count--;
            q.poll();
            if (count == 0) {
                count = q.size();
                coast++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        L0127BFS test = new L0127BFS();
        System.out.println(test.ladderLength(
                "hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));

    }
}
