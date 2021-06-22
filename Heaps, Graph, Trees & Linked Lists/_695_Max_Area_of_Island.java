public class _695_Max_Area_of_Island {
    //like _200

    //dfs can also be done with stack!
    //always recheck the limits of i and j! SMC 
    public int sink(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0)
            return 0;
        grid[i][j] = 0;//sink
        
        return 1 + sink(grid, i+1, j) +
        sink(grid, i-1, j) +
        sink(grid, i, j+1) +
        sink(grid, i, j-1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; i ++){
            for(int j = 0; j < grid[0].length; j ++){
                
                ans = Math.max(ans, sink(grid, i, j));
            }
        }
        return ans;
    }
}
