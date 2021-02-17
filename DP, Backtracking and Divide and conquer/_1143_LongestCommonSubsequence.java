//best way to understand: https://www.youtube.com/watch?v=4Urd0a0BNng&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=19
class _1143_LongestCommonSubsequence {
    public int LCS(String x, String y, int m, int n, int[][] t){
        if(m==0||n==0)
            return 0;
        if(t[m][n]!=-1)
            return t[m][n];
        if(x.charAt(m-1)==y.charAt(n-1))
            return t[m][n] = 1 + LCS(x, y, m-1, n-1, t);
        return t[m][n]=Math.max(LCS(x, y, m-1, n, t), LCS(x, y, m, n-1, t));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int t[][]=new int[text1.length()+1][text2.length()+1];
        for(int i=0; i<=text1.length(); i++)
            for(int j=0; j<=text2.length(); j++)
                t[i][j]=-1;
        return LCS(text1, text2, text1.length(), text2.length(), t);
    }
}
