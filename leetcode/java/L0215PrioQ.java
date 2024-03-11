package leetcode.java;

import java.util.*;

public class L0215PrioQ {
    public static int topK(int[] nums, int k) {
        PriorityQueue<Integer> data = new PriorityQueue<>();
        for (int i : nums) {
            data.offer(i);
            if (data.size() > k)
                data.poll();
        }
        return data.poll();
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
