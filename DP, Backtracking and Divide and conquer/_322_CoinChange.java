class _322_CoinChange {
    //CATCH in the base condition. watch for details: https://www.youtube.com/watch?v=I-l6PBeERuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16
    //an additional row is pre-initialized
    
    //top down
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            dp[i][0]=0;
        for(int j=0;j<=amount;j++)
            dp[0][j]=Integer.MAX_VALUE-1;// any sum is impossible but mathematically if no coins, then IINF (-1 to prevent overflow by addition of 1 later)
        
        //another initialization for one coin
        for(int j=1;j<=amount;j++)
            dp[1][j]=j%coins[0]==0?j/coins[0]:Integer.MAX_VALUE-1;
        for(int i=2;i<=coins.length;i++)
            for(int j=1;j<=amount;j++)
                if(coins[i-1]<=j)
                    dp[i][j]=Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                else
                    dp[i][j]=dp[i-1][j];
        return dp[coins.length][amount]>=Integer.MAX_VALUE-1?-1:dp[coins.length][amount];
    }
    
    //recursion + memoization
    public int numCoins(int[] coins, int amount, int n, int dp[][]) {
        if(n==0) return Integer.MAX_VALUE-1;
        if(amount==0)
            return 0;
        if(n==1 && amount % coins[n-1]==0)
            return amount / coins[n-1];
        else if(n==1 && amount % coins[n-1]!=0)
            return Integer.MAX_VALUE-1;
        if(dp[n][amount]!=-1)
            return dp[n][amount];
        if(coins[n-1]<=amount)
            return dp[n][amount]=Math.min(numCoins(coins, amount, n-1, dp), 1+ numCoins(coins, amount-coins[n-1], n, dp));
        return dp[n][amount]=numCoins(coins, amount, n-1, dp);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int i=0;i<=coins.length;i++)
            for(int j=0;j<=amount;j++)
                dp[i][j]=-1;
        int ans= numCoins(coins, amount, coins.length, dp);
        if(ans==Integer.MAX_VALUE || ans==Integer.MAX_VALUE-1)
            return -1;
        return ans;
    }

    //pure recursion
    public int numCoins(int[] coins, int amount, int n) {
        if(n==0) return Integer.MAX_VALUE-1;
        if(amount==0)
            return 0;
        if(n==1 && amount % coins[n-1]==0)
            return amount / coins[n-1];
        else if(n==1 && amount % coins[n-1]!=0)
            return Integer.MAX_VALUE-1;
        if(coins[n-1]<=amount)
            return Math.min(numCoins(coins, amount, n-1), 1+ numCoins(coins, amount-coins[n-1], n));
        return numCoins(coins, amount, n-1);
    }
    public int coinChange(int[] coins, int amount) {
        int ans= numCoins(coins, amount, coins.length);
        if(ans==Integer.MAX_VALUE || ans==Integer.MAX_VALUE-1)
            return -1;
        return ans;
    }
}
