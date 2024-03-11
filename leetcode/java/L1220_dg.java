package leetcode.java;

import java.util.*;

class L1220_dg {
    private Map<KeyObj, Long> cache = new HashMap<>();

    class KeyObj {
        private char c;
        private int remain;

        public KeyObj(char c, int remain) {
            this.c = c;
            this.remain = remain;
        }

        public char getC() {
            return c;
        }

        public int getRemain() {
            return remain;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || o.getClass() != this.getClass())
                return false;
            KeyObj other = (KeyObj) o;
            return other.getC() == this.getC() && other.getRemain() == this.remain;
        }

        @Override
        public int hashCode() {
            return Objects.hash(c, remain);
        }
    }

    public int countVowelPermutation(int n) {
        return (int) ((tree('a', n) + tree('i', n)) % 1000000007
                + (((tree('u', n) + tree('e', n)) % 1000000007 + tree('o', n))) % 1000000007) % 1000000007;
    }

    public Long tree(char c, int remain) {
        KeyObj thisTree = new KeyObj(c, remain);
        if (cache.containsKey(thisTree)) {
            return cache.get(thisTree);
        }

        remain--;
        long value = 0;
        if (remain == 0)
            value = 1;
        else {
            switch (c) {
                case 'a':
                    value = tree('e', remain);
                    break;
                case 'i':
                    value = tree('a', remain) + tree('u', remain) + tree('e', remain)
                            + tree('o', remain);
                    break;
                case 'u':
                    value = tree('a', remain);
                    break;
                case 'e':
                    value = tree('a', remain) + tree('i', remain);
                    break;
                case 'o':
                    value = tree('i', remain) + tree('u', remain);
                    break;
            }
        }
        value %= 1000000007;
        cache.put(thisTree, value);
        return value;
    }

    public static void main(String[] args) {
        L1220_dg solution = new L1220_dg();
        // System.out.println(solution.countVowelPermutation(1));
        // System.out.println(solution.countVowelPermutation(2));
        // System.out.println(solution.countVowelPermutation(5));
        System.out.println(solution.countVowelPermutation(10000));
    }
}