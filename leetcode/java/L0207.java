package leetcode.java;

// import java.util.*;

public class L0207 {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] course = new int[numCourses];
        int[] totake = new int[numCourses];
        int point = 0, last = 0;
        int num_took = 0, taking;
        for (int[] i : prerequisites)
            course[i[0]]--;
        // Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < course.length; i++)
            if (course[i] == 0)
                totake[last++] = i;
        // q.add(i);
        // while (!q.isEmpty()) {
        while (point < last) {
            // taking = q.poll();
            taking = totake[point++];
            course[taking] = 1;
            num_took++;
            for (int[] i : prerequisites)
                if (i[1] == taking) {
                    course[i[0]]++;
                    if (course[i[0]] == 0)
                        totake[last++] = i[0];
                    // q.add(i[0]);
                }
        }

        return num_took == numCourses;

    }

    public static void main(String[] args) {
        System.out.println(
                L0207.canFinish(
                        2,
                        new int[][] { { 1, 0 } }));
        System.out.println(
                L0207.canFinish(
                        2,
                        new int[][] { { 1, 0 }, { 0, 1 } }));
        System.out.println(
                L0207.canFinish(
                        5,
                        new int[][] { { 1, 4 }, { 2, 4 }, { 3, 1 }, { 3, 2 } }));
    }
}
