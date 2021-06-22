public class _221_Maximal_square_matrix_dp {
    //exactly like _1277. the only modification ins 'ans'
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==0 || n==0) return 0;
        
        int t[][] = new int[m][n];
        int ans = 0;
        for(int r = 0; r < m; r ++){
            for(int c = 0; c < n; c ++){
                if(matrix[r][c] == '1'){
                    if(r >0 && c > 0)
                        t[r][c] = 1 + Math.min(Math.min(t[r-1][c], t[r][c-1]), t[r-1][c-1]);
                    else
                        t[r][c] = 1;
                }
                ans = Math.max(ans, t[r][c]*t[r][c]);
            }
        }
        return ans;
    }
}
