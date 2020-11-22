import java.util.*;

class _518_CoinChange2 {
    /*
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
    public int change(int amount, int[] coins) {

    }

    public static void main(String args[]) {
        _518_CoinChange2 obj = new _518_CoinChange2();
        int amount = 5;
        int[] coins = { 1, 2, 5 };
        System.out.println(obj.change(amount, coins));
    }
}
