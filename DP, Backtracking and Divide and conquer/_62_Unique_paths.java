public class _62_Unique_paths {
    //Ez
    public int uniquePaths(int m, int n) {
        if(m == 1 && n == 1) return 1;
        int t[][] = new int [m][n];
        t[0][0] = 0;
        for(int i = 1; i < m; i++)
            t[i][0] =  1;
        for(int i = 1; i < n; i++)
            t[0][i] =  1;
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++)
                t[i][j] = t[i - 1][j] + t[i][j - 1];
        }
        return t[m-1][n-1];
    }
}
