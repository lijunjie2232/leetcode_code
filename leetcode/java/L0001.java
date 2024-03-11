package leetcode.java;

import java.util.*;

class L0001 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(nums[i])) {
                return new int[] { cache.get(nums[i]), i };
            } else {
                cache.put(target - nums[i], i);
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        L0001 solution = new L0001();
        System.out.println(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
    }
}