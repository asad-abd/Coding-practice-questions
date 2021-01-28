//sort based on the cost of sending a person to A instead to B
//i.e.: sort by = costs[i][0]-costs[i][1] 
class _1029_Two_City_Scheduling {
    public int twoCitySchedCost(int[][] costs) {
        int ans=0;
        
        Arrays.sort(costs,new Comparator<int[]>(){
            
            public int compare(int[] p, int[] q){
                return Integer.compare(p[0]-p[1],q[0]-q[1]);
            }
        });
        for(int i=0;i<costs.length;i++){
            if(i<costs.length/2)
                ans+=costs[i][0];
            else
                ans+=costs[i][1];
        }
        return ans;
    }

    //DP version:
    public int twoCitySchedCost(int[][] costs) {
        int ans=0;
        int n=costs.length/2;
        int dp[][]=new int[n+1][n+1];
        //dp[i][j]: for the first (i+j) people I have sent i to A and j to B
        //dp[i][j]=Math.min(dp[i-1][j]+costs[i][0], dp[i][j-1]+costs[i][1])
        //Let's say the (i+j)th person comes, we can either send him to A or to B
        //if we send him to A, that means there were i-1 people in A and j in B.
        //else if we send him to B, that means there were i people in A and j-1 in B.
        for(int i=1;i<=n;i++){
            dp[i][0]=dp[i-1][0]+costs[i-1][0];
            dp[0][i]=dp[0][i-1]+costs[i-1][1];
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.min(dp[i-1][j]+costs[i+j-1][0], dp[i][j-1]+costs[i+j-1][1]);
                
            }
        }
        return dp[n][n];
    }
}