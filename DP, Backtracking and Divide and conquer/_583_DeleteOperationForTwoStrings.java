//core idea is: a -> lcs && b -> lcs. add the difference of their lengths.
//checkout YT: Aditya verma for more details
class _583_DeleteOperationForTwoStrings {
    public int LCS(String x, String y){
        int m=x.length(), n=y.length();
        int t[][]=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(x.charAt(i-1)==y.charAt(j-1))
                    t[i][j]=1 + t[i-1][j-1];
                else
                    t[i][j]= Math.max(t[i][j-1],t[i-1][j]); 
            }
        }
        return t[m][n];
    }
    public int minDistance(String word1, String word2) {
        int lcs=LCS(word1,word2);
        return word1.length() + word2.length() - 2*lcs;
    }
}
