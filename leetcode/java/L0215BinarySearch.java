package leetcode.java;

public class L0215BinarySearch {
    public static int topK(int[] nums, int k) {
        int[] data = nums;
        int l = 0, r = nums.length - 1, m = k, val, i, j;
        while (m != k - 1) {
            val = data[l];
            i = l;
            j = r;
            while (i < j) {// 当l == r时，就是调整完成时
                // 从后往前找第一个小于val的数字
                while (i < j && data[j] < val) {
                    j--;
                }
                if (i < j) {// 找到了数字
                    data[i++] = data[j];
                }
                // 从前往后找第一个大于val的数字
                while (i < j && data[i] > val) {
                    i++;
                }
                if (i < j) {// 找到了数字
                    data[j--] = data[i];
                }
            }
            data[i] = val;
            m = i;
            System.out.println("m:" + m);

            if (m < k - 1) {
                l = i + 1;
            } else if (m > k - 1) {
                r = i - 1;
            }
        }
        // for (int d : data)
        // System.out.print(d);
        // System.out.println();
        return data[m];
    }

    public static void main(String[] args) {
        int[] testData1 = { 3, 2, 1, 5, 6, 4 };
        int testK1 = 2;
        System.out.println(topK(testData1, testK1));
        int[] testData2 = new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int testK2 = 4;
        System.out.println(topK(testData2, testK2));
    }
}
