package leetcode.java;

public class L0376 {
    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int cnt = 1, last = nums[0], status = 0, point = 0;
        while (status == 0 && ++point < nums.length) {
            if (nums[point] < last)
                status = -1;
            else if (nums[point] > last)
                status = 1;
        }
        System.out.println(String.format("point: %d", point));
        while (point < nums.length) {
            if ((nums[point] - last) * status > 0) {
                System.out.println(String.format("last: %d", last));
                cnt++;
                status *= -1;
            }
            last = nums[point];
            point++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[] { 1, 7, 4, 9, 2, 5 }));
        System.out.println(wiggleMaxLength(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 }));
        System.out.println(wiggleMaxLength(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
        System.out.println(wiggleMaxLength(new int[] { 33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55,
                40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19,
                27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76,
                100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52,
                38, 74, 15 }));

    }
}
