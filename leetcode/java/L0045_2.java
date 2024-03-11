package leetcode.java;

public class L0045_2 {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int Jump(int[] nums) {
        if (nums.length < 2)
            return 0;
        int cur_farest = nums[0], pre_farest = cur_farest, jump = 1, point = 0;
        while (point < nums.length) {
            if (point > pre_farest) {
                pre_farest = cur_farest;
                jump++;
            }
            cur_farest = max(nums[point] + point, cur_farest);
            point++;
        }
        return jump;
    }

    public static void main(String[] args) {
        System.out.println(Jump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(Jump(new int[] { 2, 3, 0, 1, 4 }));
        System.out.println(Jump(new int[] { 1, 1, 1, 1, 1 }));
        System.out.println(Jump(new int[] {}));
    }
}
