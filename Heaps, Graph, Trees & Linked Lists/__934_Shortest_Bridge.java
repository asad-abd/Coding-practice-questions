public class __934_Shortest_Bridge {
    //silly mistake done!! break the sink loop properly!!!
    //DFS(sink, mark visited and add to queue)  ==>  BFS. SMD: break the sink loop properly!
    public void sinkTo2(int[][] grid, int i, int j, Queue<int[]> q, boolean [][] visited){
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] == 0)
            return;
        
        grid[i][j] = 0;
        visited[i][j] = true;
        q.add(new int[]{i, j});
        
        sinkTo2(grid, i + 1, j, q, visited);
        sinkTo2(grid, i, j + 1, q, visited);
        sinkTo2(grid, i - 1, j, q, visited);
        sinkTo2(grid, i, j - 1, q, visited);
    }
    public int shortestBridge(int[][] grid) {
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        boolean stop = false;
        for(int i = 0;!stop && i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1){
                    sinkTo2(grid, i, j, q, visited);
                    stop = true;
                    break;
                }
        
        //bfs (LEVEL ORDER traversal!) to find the 
        //q already has the co ordinates of first island.
        int level = 0, i = 0, j = 0;//answer > 0 or the islands are same!
        while(q.size()>0){
            int size = q.size();
            for(int ii = 0; ii < size; ii++){
                int[] node = q.poll();
                i = node[0];
                j = node[1];
                //System.out.println(i+"  STUPID  "+ j + " level : " + level);
                if(i < grid.length - 1 && !visited[i + 1][j]){
                    if(grid[i + 1][j] == 1){
                        return level;
                    }
                    visited[i + 1][j] = true;
                    q.add(new int[]{i + 1, j});
                }
                if(j < grid[0].length - 1 && !visited[i][j + 1]){
                    if(grid[i][j + 1] == 1){
                        return level;
                    }
                    visited[i][j + 1] = true;
                    q.add(new int[]{i, j + 1});
                }
                if(i > 0 && !visited[i - 1][j]){
                    if(grid[i - 1][j] == 1){
                        return level;
                    }
                    visited[i - 1][j] = true;
                    q.add(new int[]{i - 1, j});
                }
                if(j > 0 && !visited[i][j - 1]){
                    if(grid[i][j - 1] == 1){
                        return level;
                    }
                    visited[i][j - 1] = true;
                    q.add(new int[]{i, j - 1});
                }
            }
            level ++;
        }
        return level - 1;
    }
}
