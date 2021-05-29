class _gfg_Distance_of_nearest_cell_having_1 {
    //simple bfs.
    //since all values in queue are at the same level, 
    //all have same ans value, so all give same for [ans at node]+1
                 
    public int[][] nearest(int[][] grid)
    {
        int R=grid.length;
        int C=grid[0].length;
        int ans[][]=new int[R][C];
        
        Queue<int[]> q=new LinkedList<>();
        int r,c;
        for(r=0;r<R;r++){
            for(c=0;c<C;c++){
                if(grid[r][c]==1){
                    ans[r][c]=0;
                    q.add(new int[]{r,c});    
                }
                else
                    ans[r][c]=-1;
            }
        }
        //bfs
        
        while(q.size()>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] node=q.poll();
                r=node[0];
                c=node[1];
                //mark its neighbors if [ans at node]+1 if neighbor is -1 and add it to q
                
                //left
                if(r-1>=0 && ans[r-1][c]==-1){
                    ans[r-1][c]=ans[r][c]+1;
                    q.add(new int[]{r-1,c});
                }
                //down
                if(c-1>=0 && ans[r][c-1]==-1){
                    ans[r][c-1]=ans[r][c]+1;
                    q.add(new int[]{r,c-1});
                }
                //right
                if(r+1<R && ans[r+1][c]==-1){
                    ans[r+1][c]=ans[r][c]+1;
                    q.add(new int[]{r+1,c});
                }
                //up
                if(c+1<C && ans[r][c+1]==-1){
                    ans[r][c+1]=ans[r][c]+1;
                    q.add(new int[]{r,c+1});
                }
            }
        }
        return ans;
    }
}
