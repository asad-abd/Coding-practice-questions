//R1 Aug done
class _416_PartitionEqualSubsetSum_Knapsack {
    //R1 Aug: rec + memo (the previous bottom up solution seems un-intuitive now (after 8 mths))
    //TLE without t[][]
    public boolean knapsack(int arr[], int n, int sum, int [][] t){
        if(sum == 0)
            return true;
        if(sum < 0 || n == 0) // && sum != 0
            return false;
        //if(t[n][sum] == 1 || t[n][sum] == 2)
            return t[n][sum] == 1 ? false : true;
        //else
        boolean ans = false;
        //choose
        ans = ans | knapsack(arr, n - 1, sum - arr[n - 1], t);
        //not choose
        ans = ans | knapsack(arr, n - 1, sum, t);
        if(ans == true)
            t[n][sum] = 2;
        else
            t[n][sum] = 1;
        return ans;
    }
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums)
            total += num;
        if(total % 2 != 0) return false;
        
        int [][] t = new int[nums.length + 1][total + 1];
        return knapsack(nums, nums.length, total / 2, t);
    }

    // my thinking and approach: 0-1 knapsack
    // a1, a2. a3 .... ai,...an
    // first i numbers: first 1 numbers: |-> pick a1 => sum=a1 (dp[1][sum=a1]=true)
    //                                   |-> don't pick a1 => sum=0 (dp[1][sum=0]=true)
    
    // first 2 numbers: |-> pick a2 => sum= a1+a2 or 0+a2 (two new dp values marked true, dp[2][a1+a2] and dp[2][a2])
    //                  |-> don't pick => sum= a1+0 or 0+0 (two new dp values marked true, dp[2][a1] and dp[2][0])
    
    //so on... If at the end, dp[nums.length][sum]==false => such a distribution not possible. else, possible.
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2!=0)
            return false;

        boolean dp[][]=new boolean[nums.length+1][sum+1];
        dp[0][0]=true;//base case
        for(int i=1;i<=nums.length;i++){
            for(int j=0;j<=sum;j++){
                if(dp[i-1][j]==true){
                    dp[i][j+nums[i-1]]=true;
                    dp[i][j]=true;
                    //optimize a little
                    if(j+nums[i-1] ==sum/2)
                        return true;
                }
            }
        }

        return dp[nums.length][sum/2];
        //if we can find a subset that has SUM=sum/2 after evaluating all the inputs, we return true;

    }

}
