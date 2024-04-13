package datastructure;

import java.util.Scanner;

public class UnionFind {
    private int[] eleAndGroup;// 记录结点元素和该元素所在分组的标识
    private int count;// 记录并查集中数据分组的个数

    public UnionFind(int Num) {
        // 初始化分组的数量，默认情况下，有N个分组
        this.count = Num;

        // 初始化eleAndGroup数组
        this.eleAndGroup = new int[Num];

        // 初始化eleAndGroup数组中的元素及其所在组的标识符，让eleAndGroup数组的索引作为并查集的每个节点的元素，
        // 并且让每个索引处的值作为其标识符
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }

    }

    // 获取当前并查集中的数据有多少组
    public int count() {
        return count;
    }

    // 元素i所在分组的标识符
    public int find(int i) {
        return eleAndGroup[i];
    }

    // 判断并查集中元素i和j是否在同一组中
    public boolean isConnected(int i, int j) {
        return find(i) == find(j);
    }

    // 把i元素所在的分组和j所在的分组进行合并
    public void union(int i, int j) {
        // 判断元素i和j是否在同一分组中，如果在同一分组直接结束方法
        if (isConnected(i, j)) {
            return;
        }

        // 找到i所在分组的标识符
        int iGroup = find(i);

        //
        int jGroup = find(j);

        // 合并组，让i所在组的所有元素的标志符变为j的标识符

        for (int n = 0; n < eleAndGroup.length; n++) {
            if (eleAndGroup[n] == iGroup) {
                eleAndGroup[n] = jGroup;
            }

        }

        this.count--;

    }

}
