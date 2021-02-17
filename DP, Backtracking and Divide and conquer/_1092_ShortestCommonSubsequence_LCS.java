class _1092_ShortestCommonSubsequence_LCS {
    //watch aditya verma video.
    //approach is similar to printing lcs, except, when same character, take it once
    //when different, add the char whose index is about to change.
    //at the end, if either of m or n is >0, traverse over the leftover chars and add them to ans
    int LCS(String x, String y, int m, int n, int dp[][]){
        if(m==0 || n==0)
            return 0;
        if(dp[m][n]!=-1)
            return dp[m][n];
        if(x.charAt(m-1)==y.charAt(n-1))
            return dp[m][n]=1 + LCS(x, y, m-1, n-1, dp);
        return dp[m][n]=Math.max(LCS(x,y,m-1,n,dp), LCS(x,y,m,n-1,dp));      
    }
    public String printSCS(String x, String y, int dp[][], int m, int n){
        StringBuilder str=new StringBuilder();
        //go through the dp table to find the LCS string
        while(m>0 && n>0){
            if(x.charAt(m-1)==y.charAt(n-1)) {
                str.append(x.charAt(m-1));
                m--; n--;
            }
            else{
                if(dp[m-1][n]==dp[m][n]) {
                    
                    str.append(x.charAt(m-1));
                    m--;
                }
                else {
                    str.append(y.charAt(n-1));
                    n--;
                }
            }
        }
        while(m>0){
            str.append(x.charAt(m-1));
            m--;
        }
        while(n>0){
            str.append(y.charAt(n-1));
            n--;
        }
        
        return str.reverse().toString();
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        int m=str1.length(), n=str2.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        int lcsLength=LCS(str1, str2, m, n, dp);
        String scs=printSCS(str1, str2, dp, m, n);
        //System.out.println("LCS: "+lcsLength+" string: "+ scs);
        
        return scs;
    }
}
        //below code displays LCS dp table
        /*for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++)
                System.out.print(dp[i][j]+"\t");
            System.out.println();
            
        }*/
