//https://www.youtube.com/watch?v=iBnWHZmlIyY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=6&ab_channel=AdityaVerma
import java.util.*;
class _494_target_sum {
    //idea for array meme: [-S*n, +S*n] possible range of sums. Index with dp[S*n(base) + S'][n]

    //HashMap memo (165 ms)
    HashMap<String, Integer> hmap=new HashMap<>();
    public int fts(int[] nums, int S, int n){
        if(n==0 && S==0)
            return 1;
        if(n==0 && S!=0)
            return 0;
        String Q=""+S+","+n;
        if(hmap.containsKey(Q))
            return hmap.get(Q);
        
        hmap.put(Q, fts(nums,S-nums[n-1],n-1) + fts(nums,S+nums[n-1],n-1));
        return hmap.get(Q);
    }
    public int findTargetSumWays(int[] nums, int S) {
        return fts(nums,S,nums.length);
    }

    //pure recursive (921 ms)
    public int fts(int[] nums, int S, int n){
        if(n==0 && S==0)
            return 1;
        if(n==0 && S!=0)
            return 0;
        return fts(nums,S-nums[n-1],n-1) + fts(nums,S+nums[n-1],n-1);
    }
    public int findTargetSumWays(int[] nums, int S) {
        return fts(nums,S,nums.length);
    }
}
