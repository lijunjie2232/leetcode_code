package leetcode.java;

import java.util.*;

public class L0051 {
    public int[][] qp;
    public int xy;
    // qp[y][x]
    public static final int dx[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
    public static final int dy[] = { -1, -1, -1, 0, 1, 1, 1, 0 };

    public List<List<String>> NQueensSolutions;
    public Stack<Integer> pos;

    public void markQP(int y, int x, int val) {
        int cx, cy;
        this.qp[y][x] += val;
        for (int i = 1; i < this.xy; i++) {
            for (int j = 0; j < 8; j++) {
                cx = x + dx[j] * i;
                cy = y + dy[j] * i;
                if (cx < this.xy && cx >= 0 && cy < this.xy && cy >= 0) {
                    // if (this.qp[cy][cx] == 1)
                    // return false;
                    this.qp[cy][cx] += val;
                }
                // else
                // break;
            }
        }
        // return true;
    }

    public void formString() {
        List<String> OneSolutions = new LinkedList<>();
        StringBuffer str;
        for (int p : this.pos) {
            str = new StringBuffer();
            for (int i = 0; i < this.xy; i++)
                if (i == p)
                    str.append('Q');
                else
                    str.append('.');
            OneSolutions.add(str.toString());
        }
        this.NQueensSolutions.add(OneSolutions);
    }

    public void nextStep(int y) {
        if (y == this.xy) {
            // System.out.println(this.pos);
            formString();
            return;
        }
        for (int i = 0; i < this.xy; i++) {
            if (this.qp[y][i] == 0) {
                markQP(y, i, 1);
                this.pos.push(i);
                nextStep(y + 1);
                this.pos.pop();
                markQP(y, i, -1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.xy = n;
        this.pos = new Stack<>();
        this.NQueensSolutions = new LinkedList<>();
        this.qp = new int[n][n];
        nextStep(0);
        System.out.println(this.NQueensSolutions);
        return this.NQueensSolutions;
    }

    public static void main(String[] args) {
        L0051 test = new L0051();
        test.solveNQueens(4);
    }
}
