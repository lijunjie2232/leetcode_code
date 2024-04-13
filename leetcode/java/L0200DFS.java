package leetcode.java;

public class L0200DFS {
    char[][] data;

    public void dfps(int i, int j) {
        if (i >= 0 && j >= 0 && i < this.data.length && j < this.data[0].length && this.data[i][j] != '0') {
            this.data[i][j] = '0';
            this.dfps(i + 1, j);
            this.dfps(i - 1, j);
            this.dfps(i, j + 1);
            this.dfps(i, j - 1);
        }
    }

    public int numIslands(char[][] grid) {
        this.data = grid;
        int count = 0;
        for (int i = 0; i < this.data.length; i++) {
            for (int j = 0; j < this.data[i].length; j++) {
                if (this.data[i][j] == '0')
                    continue;
                count++;
                this.dfps(i, j);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        L0200DFS l0200Test = new L0200DFS();
        System.out.println(l0200Test.numIslands(
                new char[][] {
                        { '1', '1', '1', '1', '0' },
                        { '1', '1', '0', '1', '0' },
                        { '1', '1', '0', '0', '0' },
                        { '0', '0', '0', '0', '0' }
                }));
        System.out.println(l0200Test.numIslands(
                new char[][] {
                        { '1', '1', '0', '0', '0' },
                        { '1', '1', '0', '0', '0' },
                        { '0', '0', '1', '0', '0' },
                        { '0', '0', '0', '1', '1' }
                }));
        System.out.println(l0200Test.numIslands(
                new char[][] {
                        { '1', '1', '1', '1', '0' },
                        { '1', '1', '0', '1', '0' },
                        { '1', '1', '0', '0', '0' },
                        { '0', '0', '0', '0', '0' }
                }));
    }
}
