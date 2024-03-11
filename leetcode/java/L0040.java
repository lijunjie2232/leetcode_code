package leetcode.java;

import java.util.*;

public class L0040 {
    public List<List<Integer>> subsetsList;
    private List<Integer> subsetList;
    private int target;

    public void listWlaker(int[] nums, int index, boolean uketoru) {
        if (this.target == 0)
            this.subsetsList.add(new ArrayList<>(this.subsetList));
        if (index >= nums.length)
            return;
        else if (0 < this.target && this.target >= nums[index]) {
            this.listWlaker(nums, index + 1, false);
            if (!(index > 0 && nums[index] == nums[index - 1] && uketoru == false)) {
                this.subsetList.add(nums[index]);
                this.target -= nums[index];
                this.listWlaker(nums, index + 1, true);
                this.target += this.subsetList.get(this.subsetList.size() - 1);
                this.subsetList.remove(this.subsetList.size() - 1);
            }
        }
        return;

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.target = target;
        this.subsetList = new LinkedList<>();
        this.subsetsList = new LinkedList<>();
        this.listWlaker(candidates, 0, false);
        return this.subsetsList;
    }

    public static void main(String[] args) {
        L0040 test = new L0040();
        System.out.println(test.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
        for (List<Integer> i : test.subsetsList) {
            for (Integer j : i)
                System.out.print(String.format("%d,", j));
            System.out.println();
        }
    }
}
