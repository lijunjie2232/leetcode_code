package leetcode.java;

import java.util.*;

class SmallestPileL0215 {
    private List<Integer> pile;
    private int k;

    public SmallestPileL0215(int k) {
        this.k = k;
        this.pile = new ArrayList<>();
    }

    public void adjustDown(int pos) {
        int len = this.pile.size();
        int tmp, childPos;

        while (pos * 2 + 1 <= len - 1) {
            childPos = pos * 2 + 1;
            if (childPos + 1 <= len - 1 && this.pile.get(childPos + 1) < this.pile.get(childPos))
                childPos = childPos + 1;

            if (this.pile.get(childPos) < this.pile.get(pos)) {
                tmp = this.pile.get(pos);
                this.pile.set(pos, this.pile.get(childPos));
                this.pile.set(childPos, tmp);
                pos = childPos;
            } else
                return;
        }
    }

    public void add(int a) {
        if (this.pile.size() == this.k)
            if (a <= this.pile.get(0))
                return;
            else {
                this.pile.set(0, a);
                this.adjustDown(0);
            }
        else {
            this.pile.add(a);
            if (this.pile.size() == this.k) {
                int pos = (this.k) / 2 - 1;
                while (pos >= 0) {
                    // 调整子树
                    this.adjustDown(pos);
                    // 调整完以后，parent向前移动
                    pos--;
                }
            }
            // this.adjustAfterAdd();
        }
    }

    public int getTop() {
        return this.pile.get(0);
    }
}

public class L0215Pile {
    public static int topK(int[] nums, int k) {
        SmallestPileL0215 data = new SmallestPileL0215(k);
        for (int i : nums)
            data.add(i);
        return data.getTop();
    }

    public static void main(String[] args) {
        int[] testData1 = { 3, 2, 1, 5, 6, 4 };
        int testK1 = 2;
        System.out.println(topK(testData1, testK1));
        int[] testData2 = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int testK2 = 4;
        System.out.println(topK(testData2, testK2));
    }
}
