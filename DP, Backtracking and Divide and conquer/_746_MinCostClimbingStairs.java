class _746_MinCostClimbingStairs {
    // either reach the ith step from the i-1 th or i-2 th step.
    // Recursion: TLE (gets ttestcase right)
    public int minCostClimbingStairs(int[] cost) {
        int Cost[] = new int[cost.length + 2];
        Cost[0] = 0;
        Cost[cost.length + 1] = 0;
        for (int i = 1; i <= cost.length; i++) {
            Cost[i] = cost[i - 1];
        }
        return minCost(cost.length + 1, Cost);
    }

    public int minCost(int i, int[] cost) {
        if (i < 2)
            return cost[i];
        return Math.min(minCost(i - 1, cost), minCost(i - 2, cost)) + cost[i];
    }

    // my dp solution- works
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];

        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}