class _1672 {
    public int maximumWealth(int[][] accounts) {
        int m=accounts.length;
        int n=accounts[0].length;
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            int sum=0;
            for(int j=0;j<n;j++)
                sum+=accounts[i][j];
            ans=Math.max(ans,sum);
        }
        return ans;
    }
}
