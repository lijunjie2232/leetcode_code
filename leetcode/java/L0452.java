package leetcode.java;

import java.util.*;

public class L0452 {
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static int min(int a, int b) {
        return a < b ? a : b;
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] > b[1] ? 1 : -1;
                else
                    return a[0] > b[0] ? 1 : -1;
            }
        });

        for (int i[] : points)
            System.out.print(String.format("[%d, %d] ", i[0], i[1]));
        System.out.println();
        int point = 0, lmin = points[point][0], rmax = points[point][1], shoots = 1;
        while (point < points.length) {
            lmin = max(lmin, points[point][0]);
            rmax = min(rmax, points[point][1]);
            if (lmin <= rmax)
                point++;
            else {
                lmin = points[point][0];
                rmax = points[point][1];
                shoots++;
            }
        }
        return shoots;
    }

    public static void main(String[] args) {
        System.out.println(findMinArrowShots(new int[][] { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } }));
        System.out.println(findMinArrowShots(new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 } }));
        System.out.println(findMinArrowShots(
                new int[][] { { 9, 12 }, { 1, 10 }, { 4, 11 }, { 8, 12 }, { 3, 9 }, { 6, 9 }, { 6, 7 } }));
    }

}
