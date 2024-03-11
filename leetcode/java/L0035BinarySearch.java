package leetcode.java;

public class L0035BinarySearch {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1, m = 0;
        while (l < r) {
            m = (l + r) / 2;
            if (nums[m] == target)
                return m;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return nums[l] < target ? l + 1 : l;
    }

    public static void main(String[] args) {
        System.out.println(L0035BinarySearch.searchInsert(
                new int[] { 1, 3, 5, 6 }, 5));
        System.out.println(L0035BinarySearch.searchInsert(
                new int[] { 1, 3, 5, 6 }, 2));
        System.out.println(L0035BinarySearch.searchInsert(
                new int[] { 1, 3, 5, 6 }, 7));
        System.out.println(L0035BinarySearch.searchInsert(
                new int[] { 1, 3 }, 0));
    }
}
