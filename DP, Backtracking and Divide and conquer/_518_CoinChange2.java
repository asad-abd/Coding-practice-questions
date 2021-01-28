import java.util.*;

class _518_CoinChange2 {
   

    //recursion + memoization
    public int numCoins(int[] coins, int amount, int n, int[][] dp) {
        if(n==0 && amount!=0)
            return 0;
        if(n==0 || amount==0)
            return 1;
        if(dp[amount][n]!=-1)
            return dp[amount][n];
        int temp1=numCoins(coins,amount,n-1, dp);
        if(coins[n-1]<=amount){
            int temp=numCoins(coins,amount-coins[n-1],n, dp);
            return dp[amount][n]=temp+temp1;
        }
        return dp[amount][n]=temp1;
    }
    public int change(int amount, int[] coins) {
        int dp[][]=new int[amount+1][coins.length+1];
        for(int i=0;i<=amount;i++)
            for(int j=0;j<=coins.length;j++)
                dp[i][j]=-1;
                
        return numCoins(coins, amount, coins.length, dp);
        
    }
    
    //pure recursion
    public int numCoins(int[] coins, int amount, int n) {
        if(n==0 && amount!=0)
            return 0;
        if(n==0 || amount==0)
            return 1;
        int temp1=numCoins(coins,amount,n-1);
        if(coins[n-1]<=amount){
            int temp=numCoins(coins,amount-coins[n-1],n);
            return temp+temp1;
        }
        return temp1;
    }
    public int change(int amount, int[] coins) {
        return numCoins(coins, amount, coins.length);
        
    }
    //main
    public static void main(String args[]) {
        _518_CoinChange2 obj = new _518_CoinChange2();
        int amount = 5;
        int[] coins = { 1, 2, 5 };
        System.out.println(obj.change(amount, coins));
    }
}

 /* some old try
     * //this is based on completely diferent thinking and the code gives error.
     * //But, even if the code worked as per the logic, the problem is that we have
     * duplicate cases. so the answer we get will be more than required
     * HashMap<Integer, Integer> hmap = new HashMap<>(); public int change(int
     * amount, int[] coins) { int minCoin = coins[0]; for (int i = 0; i <
     * coins.length; i++) { if (coins[i] < minCoin) minCoin = coins[i]; }
     * hmap.put(minCoin, 1); return nWM(amount, coins, minCoin); }
     * 
     * public int nWM(int amt, int[] coins, int min) { if (amt < min) return 0;
     * 
     * if (hmap.containsKey(amt)) { return hmap.get(amt); } (double)coins.length int
     * ans = 0; for (int i = 0; i < (int)Math.ceil(((double)coins.length)/2); i++) {
     * ans += hmap.getOrDefault(amt-coins[i])nWM(amt - coins[i], coins, min) *
     * nWM(coins[i], coins, min); } System.out.println(amt + " - " + ans);
     * hmap.put(amt, ans); return ans; }
     */