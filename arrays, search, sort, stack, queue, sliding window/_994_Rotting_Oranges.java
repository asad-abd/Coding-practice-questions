public class _994_Rotting_Oranges {
    //simple bfs
    public int orangesRotting(int[][] M) {
        Queue<int[]> q=new LinkedList<>();
        int R=M.length;
        int C=M[0].length;
        int count1=0;
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(M[r][c]==1) count1++;
                if(M[r][c]==2){
                    q.add(new int[]{r,c});
                }
            }
        }
        int level=0;
        while (q.size()>0 && count1>0){
            //if(count1==0) break;//imp condition. other wise error for some [0,0]etc base cases. 
            //because int the last while loop we simply traverse a matrix full of 2s but we still increment level by 1!!
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] node = q.poll();
                int r=node[0], c=node[1];
                //mark its neighbors that are 1 as 2 and push them onto the  queue
                if(r-1>=0 && M[r-1][c]==1){
                    M[r-1][c]=2;
                    q.add(new int[]{r-1,c});
                    count1--;
                }
                if(r+1<R && M[r+1][c]==1){
                    M[r+1][c]=2;
                    q.add(new int[]{r+1,c});
                    count1--;
                }
                if(c-1>=0 && M[r][c-1]==1){
                    M[r][c-1]=2;
                    q.add(new int[]{r,c-1});
                    count1--;
                }
                if(c+1<C && M[r][c+1]==1){
                    M[r][c+1]=2;
                    q.add(new int[]{r,c+1});
                    count1--;
                }
            }
            level++;
        }
        if(count1>0) return -1;
        return level;
    }
}
