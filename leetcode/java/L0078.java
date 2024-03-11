package leetcode.java;

import java.util.*;

public class L0078 {
    public List<List<Integer>> subsetsList;
    private List<Integer> subsetList;

    public void listWlaker(int[] nums, int index) {
        // this.subsetsList.add(this.subsetList);
        if (index < nums.length) {
            this.listWlaker(nums, index + 1);
            this.subsetList.add(nums[index]);
            this.listWlaker(nums, index + 1);
            this.subsetList.remove(this.subsetList.size() - 1);
        } else
            // return;
            this.subsetsList.add(new LinkedList<>(this.subsetList));
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.subsetList = new LinkedList<>();
        this.subsetsList = new LinkedList<>();
        this.listWlaker(nums, 0);
        return this.subsetsList;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        L0078 test = new L0078();
        System.out.println(test.subsets(nums).size());
        for (List<Integer> i : test.subsetsList) {
            for (Integer j : i)
                System.out.print(String.format("%d,", j));
            System.out.println();
        }
    }
}
