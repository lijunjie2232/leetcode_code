package leetcode.java;

public class L0033BinarySearch {
    int[] array;
    int rp;

    public void arrayInit(int[] nums) {
        this.array = nums;
        int l = 0, r = nums.length - 1, m = 0;
        this.rp = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (m != 0 && nums[m - 1] > nums[m]) {
                this.rp = m;
                return;
            } else if (nums[m] > nums[r])
                l = m + 1;
            else
                r = m - 1;
        }
    }

    public int indexMap(int index) {
        return (index + this.rp) % this.array.length;
    }

    public int getItem(int index) {
        return this.array[this.indexMap(index)];
    }

    public int search(int[] nums, int target) {
        this.arrayInit(nums);
        int l = 0, r = nums.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            // System.out.println(this.getItem(m));
            if (this.getItem(m) == target)
                return this.indexMap(m);
            else if (this.getItem(m) < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        // int[] a = new int[] { 1 };
        L0033BinarySearch test = new L0033BinarySearch();
        System.out.println(
                test.search(a, 2));
    }
}
