package leetcode.java;

import java.util.*;

public class L0315 {
    class ElemL0315 {
        public Integer val;
        public Integer originIndex;

        public ElemL0315(int val, int oi) {
            this.val = val;
            this.originIndex = oi;
        }
    }

    public int[] count;
    // public List<ElemL0315> data;
    public ElemL0315[] data;

    public void mergeSort(int l, int m, int r) {
        // List<ElemL0315> tmp = new LinkedList<ElemL0315>();
        ElemL0315[] tmp = new ElemL0315[r - l + 1];
        int a = l, b = m, p = 0;
        while (a < m && b <= r) {
            if (data[a].val > data[b].val)
                tmp[p++] = data[b++];
            else {
                this.count[data[a].originIndex] += b - m;
                tmp[p++] = data[a++];
            }
        }
        while (a < m) {
            this.count[data[a].originIndex] += b - m;
            tmp[p++] = data[a++];
        }
        while (b <= r)
            tmp[p++] = data[b++];
        a = 0;
        b = l;
        while (b <= r)
            // this.data.set(b++, tmp.get(a++));
            this.data[b++] = tmp[a++];
    }

    public void split(int l, int r) {
        if (l == r)
            return;
        int m = (l + r + 1) / 2;
        this.split(l, m - 1);
        this.split(m, r);
        this.mergeSort(l, m, r);
    }

    public List<Integer> countSmaller(int[] nums) {
        // this.data = new ArrayList<>();
        data = new ElemL0315[nums.length];
        // count = new ArrayList<>();
        count = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            data[i] = new ElemL0315(nums[i], i);

        List<Integer> result = new LinkedList<>();
        this.split(0, nums.length - 1);
        for (int i : this.count)
            result.add(i);
        return result;
    }

    public static void main(String[] args) {
        L0315 test = new L0315();
        int[] data;
        data = new int[] { 5, 2, 6, 1 };
        data = new int[] { -1 };
        data = new int[] { -1, -1 };
        Random numList = new Random(6);
        data = new int[1000];
        for (int i = 0; i < 1000; i++)
            data[i] = numList.nextInt(-10000, 10000);
        // data = new int[] { 5, 2, 6, 1 };
        List<Integer> result = test.countSmaller(data);
        System.out.println(result);
    }
}
