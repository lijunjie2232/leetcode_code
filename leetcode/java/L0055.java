package leetcode.java;

public class L0055 {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static boolean canJump(int[] nums) {
        if (nums.length <= 1)
            return true;
        int[] cache = new int[nums.length];
        int lpoint = nums.length - 1, rpoint = 0;
        while (lpoint >= 0) {
            cache[lpoint] = lpoint + nums[lpoint];
            rpoint = lpoint + nums[lpoint];
            if (rpoint >= nums.length)
                rpoint = nums.length - 1;
            while (lpoint < rpoint) {
                cache[lpoint] = max(cache[rpoint--], cache[lpoint]);
            }
            lpoint--;
        }
        for (int i : cache)
            System.out.print(String.format("%d ", i));
        if (cache[0] >= nums.length - 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(canJump(new int[] { 2, 3, 2, 1, 0, 4 }));
        System.out.println(canJump(new int[] { 1, 1, 1, 1, 1 }));
        System.out.println(canJump(new int[] {}));
    }
}
