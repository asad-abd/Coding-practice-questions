
// thought up in 15 mins- recursive
//for memoization- hashing gives TLE
//use array for memoization
class _1155_NumberOfDiceRollsWithTargetSum {
    int mod = 1000000000 + 7;

    //
    public int numRollsToTarget(int n, int f, int target) {
        int dp[][] = new int[n + 1][target + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if ((j - k) >= 0) {
                        dp[i][j] += dp[i - 1][j - k];
                        dp[i][j] %= mod;
                    }
                }
            }
        }
        return dp[n][target];
    }

    // recursion + memoization:-
    public int numRollsToTarget(int n, int f, int target) {
        int dp[][] = new int[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return nRT(n, f, target, dp);
    }

    public int nRT(int n, int f, int target, int[][] dp) {
        if (n == 1 && target <= f) {
            // hmap.put((n+","+target),1);
            return 1;
        } else if (n == 1 && target > f) {
            // hmap.put((n+","+target),0);
            return 0;
        }
        int ans = 0;
        if (dp[n][target] != -1)
            return dp[n][target];
        for (int i = 1; i <= Math.min(f, target - n + 1); i++) {
            String s = "" + (n - 1) + (target - i);
            if (dp[n][target] != -1)
                ans += dp[n][target];
            else
                ans += nRT(n - 1, f, target - i, dp);
            ans %= mod;
        }

        // System.out.println((n+target));
        dp[n][target] = ans;
        return ans;

    }
}
