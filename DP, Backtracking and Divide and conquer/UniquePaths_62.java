
//Mid #62. don't know company
//will call it easy
import java.util.*;

class UniquePaths_1 {
    // soln 2- discussion- This is a combinatorial problem and can be solved without
    // DP. For mxn grid, robot has to move exactly m-1 steps down and n-1 steps
    // right and these can be done in any order.
    // Total permutations = (m+n)! / (m! * n!)

    // Soln 3- discussion- a little optimization of the space, 1-D array:
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }

        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    // solution 1- (my)- done in 13 mins
    public int uniquePaths_1(int m, int n) {
        int grid[][] = new int[m][n];
        int numUP[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            numUP[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            numUP[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                numUP[i][j] = numUP[i - 1][j] + numUP[i][j - 1];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(numUP[i][j] + " ");
            }
            System.out.println();
        }
        return numUP[m - 1][n - 1];
    }

}
