public class __329_Longest_Increasing_Path_in_a_Matrix {
    //observe that we cannot have cycles in this! 
    //M1: make a directed graph (is acyclic in this question). then topological sort.
    //try later

    //M2: memoized dfs (or using PQ<>)
    //no need of visited - only due to the problem stmt. 
    //if it would have been non decreasing path then I would have required a visited DS. 
    int dirs[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    public int dfs(int [][] matrix, int i, int j, int [][] memo){
        if(memo[i][j] != 0)
            return memo[i][j];
        int ans = 0;
        for(int dir[] : dirs){
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if(newI >= 0 && newI < matrix.length && newJ >= 0 && newJ < matrix[0].length && matrix[newI][newJ] > matrix[i][j])
                ans = Math.max(ans, dfs(matrix, newI, newJ, memo));
        }
        return memo[i][j] = ans + 1; 
    }
    public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        int [][] memo = new int [matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i ++){
            for(int j = 0; j < matrix[0].length; j ++){
                ans = Math.max(ans, dfs(matrix, i, j, memo));
                //System.out.println();
            }
        }
        return ans;
    }
}
