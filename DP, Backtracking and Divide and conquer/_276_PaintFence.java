// https://leetfree.com/problems/paint-fence.html   -- Must Redo
//SMC problem.
class _276_PaintFence {
    static int mod = 1000000007;

    // for diff- I only care about the last 2 fences (for current i) to be different
    // which = allPossibleWays[i-1]* (k-1)
    public static int countWays(int n, int k) {
        if (n == 1)
            return k % mod;
        if (n == 2)
            return (k * k) % mod;
        int same = k % mod;
        int diff = (k * (k - 1)) % mod;
        for (int i = 2; i < n; i++) {
            int temp = same;
            same = diff;
            diff = (temp + diff) * (k - 1);
            same %= mod;
            diff %= mod;
        }
        return (same + diff) % mod;
    }

    public static void main(String[] args) {
        int n = 123, k = 69;
        System.out.println(countWays(n, k));
        System.out.println(countWaysGFG(n, k));
    }
}