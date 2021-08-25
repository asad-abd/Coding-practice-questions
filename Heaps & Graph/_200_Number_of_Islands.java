class _200_Number_of_Islands {
    //edit: in case: the islands MUST be surrounded on all 4 sides by water.
    //dfs on edges first and sink the islands without counting them. 
    //then in the next dfs sink them and count: since we've already eliminated those that were connected to edges of graph

    //amazing solution in discuss! sinking
    //can also use void below(infact it's better IMO)
    public int sink(char [][]grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length) 
            return 0;
        if(grid[i][j]=='0')
            return 0;
        //else grid[i][j]==1 -> (i,j) is part of an island, sink the surrounding land!!
        grid[i][j]='0';//important to do this first!! else stackoverflow

        sink(grid,i+1,j);
        sink(grid,i,j+1);
        sink(grid,i-1,j);
        sink(grid,i,j-1);
        
        return 1; //do not count the 1 returned from above 4 calls! since all make up one island
            
    }
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1')
                    count+=sink(grid,i,j);
            }
        }
        return count;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////
    public int numIslands(char[][] grid) {
        int m=grid.length();
        int n=grid[0]length();
        boolean visited[][]=new boolean[m][n];
        
        
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(!visited[i][j]){//start bfs from here
                    Queue<int[]> q=new LinkedList<>();
                    while(q.size()>0){
                        int node[]=q.poll(), x=node[0], y=node[1];
                        visited[x][y]=true;
                        if(x-1>=0 && !visited[x-1][y]){
                            visi
                        }
                        if(x+1<m && !visited[x+1][y]){
                            
                        }
                        if(y-1>=0 && !visited[x][y-1]){
                            
                        }
                        if(y+1<n && !visited[x][y+1]){
                            
                        }
                    }
                }
            }
        }
    }    
}
