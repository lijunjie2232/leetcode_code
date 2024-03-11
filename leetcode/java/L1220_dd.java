package leetcode.java;

class L1220_dd {

    public int countVowelPermutation(int n) {
        n--;
        long a = 1, i = 1, u = 1, e = 1, o = 1;
        final int MOD = 1000000007;
        for (int nn = 0; nn < n; nn++) {
            long ii = (a + u + e + o) % MOD;
            long ee = (a + i) % MOD;
            o = (i + u) % MOD;
            u = a;
            a = e;
            i = ii;
            e = ee;
        }
        return (int) ((a + i + u + e + o) % MOD);
    }

    public static void main(String[] args) {
        L1220_dd solution = new L1220_dd();
        System.out.println(solution.countVowelPermutation(1));
        System.out.println(solution.countVowelPermutation(2));
        System.out.println(solution.countVowelPermutation(5));
        System.out.println(solution.countVowelPermutation(155));
    }
}