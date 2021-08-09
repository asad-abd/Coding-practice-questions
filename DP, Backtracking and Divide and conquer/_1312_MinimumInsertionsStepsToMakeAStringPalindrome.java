//R1 Aug done
class _1312_MinimumInsertionsStepsToMakeAStringPalindrome {
    //number of insertions==number of deletions!!!!! (YT, Aditya Verma)
    int LCS(String x, String y, int m, int n){
        int t[][] =new int [m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(x.charAt(i-1)==y.charAt(j-1))
                    t[i][j]=1+t[i-1][j-1];
                else
                    t[i][j]=Math.max(t[i][j-1], t[i-1][j]);
            }
        }
        return t[m][n];
    }
    public int minInsertions(String s) {
        StringBuilder str=new StringBuilder(s);
        int n=str.length();
        return n-LCS(s,str.reverse().toString(),n,n);
    }
}
