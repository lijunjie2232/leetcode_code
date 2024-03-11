package leetcode.java;

import java.util.*;

public class L0078BinaryCalculate {

    public List<Integer> biCalc(int[] nums, int binary) {
        List<Integer> subsetsList = new LinkedList<>();
        int index = 1;
        for (int i = 0; i < nums.length; i++) {
            if ((index & binary) > 0)
                subsetsList.add(nums[i]);
            index <<= 1;
        }
        return subsetsList;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsList = new LinkedList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++)
            subsetsList.add(biCalc(nums, i));
        return subsetsList;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        L0078BinaryCalculate test = new L0078BinaryCalculate();
        List<List<Integer>> subsetsList = test.subsets(nums);
        for (List<Integer> i : subsetsList) {
            for (Integer j : i)
                System.out.print(String.format("%d,", j));
            System.out.println();
        }
    }
}
