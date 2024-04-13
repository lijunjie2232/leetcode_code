package leetcode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L0127DFS {
    // public List<String> wl;
    public int[][] m;
    public int minCoast;
    public int purpose;

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

    public void search(int index, int coast) {
        if (index == this.purpose) {
            if (coast < this.minCoast || this.minCoast == 0)
                this.minCoast = coast;
        } else {
            for (int i = 0; i < this.m.length; i++) {
                if (this.m[index][i] == 1) {
                    this.m[index][i] = 0;
                    this.m[i][index] = 0;
                    this.search(i, coast + 1);
                    this.m[index][i] = 1;
                    this.m[i][index] = 1;
                }
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.purpose = wordList.indexOf(endWord);
        if (this.purpose < 0)
            return 0;
        // wordList.add(endWord);
        wordList.add(beginWord);
        this.minCoast = 0;
        this.m = new int[wordList.size()][wordList.size()];
        for (int i = 0; i < wordList.size(); i++)
            for (int j = 0; j < i; j++) {
                if (this.matchConv(wordList.get(i), wordList.get(j))) {
                    System.out.println(wordList.get(i) + " " + wordList.get(j));
                    m[i][j] = 1;
                    m[j][i] = 1;
                }
            }
        this.search(wordList.size() - 1, 1);
        return this.minCoast;
    }

    public static void main(String[] args) {
        L0127DFS test = new L0127DFS();
        System.out.println(test.ladderLength(
                "hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))));
    }
}
