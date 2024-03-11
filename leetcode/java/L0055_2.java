package leetcode.java;

public class L0055_2 {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static boolean canJump(int[] nums) {
        int max2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max2)
                return false;
            max2 = max(max2, nums[i] + i);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(canJump(new int[] { 2, 3, 2, 1, 0, 4 }));
        System.out.println(canJump(new int[] { 1, 1, 1, 1, 1 }));
        System.out.println(canJump(new int[] {}));
    }
}
