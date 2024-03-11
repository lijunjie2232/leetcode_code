package leetcode.java;

import java.util.*;

public class L0090 {
    public Set<List<Integer>> subsets;
    public List<Integer> subset;

    public void listWalker(int[] nums, int index) {
        // this.subsetsList.add(this.subsetList);
        if (index < nums.length) {
            this.listWalker(nums, index + 1);
            this.subset.add(nums[index]);
            this.listWalker(nums, index + 1);
            this.subset.remove(this.subset.size() - 1);
        } else
            // return;
            this.subsets.add(new LinkedList<>(this.subset));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.subsets = new HashSet<>();
        this.subset = new LinkedList<>();
        Arrays.sort(nums);
        this.listWalker(nums, 0);
        List<List<Integer>> r = new LinkedList<>();
        for (List<Integer> s : this.subsets)
            r.add(s);
        return r;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };
        L0090 test = new L0090();
        System.out.println(test.subsetsWithDup(nums).size());
        for (List<Integer> i : test.subsets) {
            for (Integer j : i)
                System.out.print(String.format("%d,", j));
            System.out.println();
        }
    }
}
