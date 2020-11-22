class _1310_XORQueriesOfASubarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        
        int dp[]=new int[arr.length];
        int ans[]=new int[queries.length];
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            dp[i]=arr[i]^dp[i-1];
        }
        int j=0;
        for(int query[]: queries){
            if(query[0]!=0)
                ans[j++]=dp[query[0]-1]^dp[query[1]];
            else
                ans[j++]=dp[query[1]];
        }
        return ans;
    }
}
