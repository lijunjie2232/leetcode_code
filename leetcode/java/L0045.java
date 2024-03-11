package leetcode.java;

public class L0045 {
    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int Jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int[] cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            cache[i] = 10001;
        int lpoint = 0, rpoint = 0;
        cache[0] = 0;
        while (lpoint < nums.length) {
            rpoint = lpoint + nums[lpoint];
            if (rpoint >= nums.length)
                rpoint = nums.length - 1;
            while (lpoint < rpoint) {
                if (cache[rpoint] == 0)
                    cache[rpoint] = cache[lpoint] + 1;
                else
                    cache[rpoint] = min(cache[lpoint] + 1, cache[rpoint]);
                rpoint--;
            }
            lpoint++;
        }
        for (int i : cache)
            System.out.print(String.format("%d ", i));
        System.out.println();
        return cache[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(Jump(new int[] { 2, 3, 1, 1, 4 }));
        System.out.println(Jump(new int[] { 2, 3, 0, 1, 4 }));
        System.out.println(Jump(new int[] { 1, 1, 1, 1, 1 }));
        System.out.println(Jump(new int[] {}));
    }
}
