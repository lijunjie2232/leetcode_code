package leetcode.java;

public class L0034BinarySearch {
    public static int[] searchRange(int[] nums, int target) {
        int lPoint = -1, rPoint = -1;
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target)
                if (m == nums.length - 1 || nums[m + 1] > target) {
                    rPoint = m;
                    break;
                } else
                    l = m + 1;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] == target)
                if (m == 0 || nums[m - 1] < target) {
                    lPoint = m;
                    break;
                } else
                    r = m - 1;
            else if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        System.out.println(String.format("%d, %d", lPoint, rPoint));
        return new int[] { lPoint, rPoint };
    }

    public static void main(String[] args) {
        L0034BinarySearch.searchRange(
                new int[] { 5, 7, 7, 8, 8, 10 }, 8);
        L0034BinarySearch.searchRange(
                new int[] { 5, 7, 7, 8, 8, 10 }, 6);
        L0034BinarySearch.searchRange(
                new int[] { 1 }, 1);
        L0034BinarySearch.searchRange(
                new int[] { 1, 1 }, 1);
    }
}
