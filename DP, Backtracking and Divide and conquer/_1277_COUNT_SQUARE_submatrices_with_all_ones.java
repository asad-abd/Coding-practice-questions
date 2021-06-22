public class _1277_COUNT_SQUARE_submatrices_with_all_ones {
    //SOLUTION APPROACH : https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
    
    //in the t[][] matrix t[i][j] stores the number of squares (i,j) is a part of AS A BOTTOM RIGHT ELEMENT!!!! 
    //if the minimum value for (i,j) on t: left, up or up-left is of size 2.
    //it means that we have 2 atleast squares with all the surrounding cells.
    
    //CRUX OF THE ALGO: NOTICE THAT NUMBER OF SQUARES IS ALSO EQUAL TO THE LARGEST SQUARE WITH THAT CELL AS THE BOTTOM RIGHT!!
    public int countSquares(int[][] matrix) {
        int R=matrix.length;
        int C=matrix[0].length;
        if(R==0 || C==0) return 0;
        
        int ans = 0;
        int[][] t = new int [R][C];
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(matrix[r][c]==1) {
                    t[r][c]++;
                    if(r>0 && c>0){
                        int smallest_neighbor = Math.min(Math.min(t[r-1][c-1], t[r][c-1]), t[r-1][c]);
                        t[r][c] += smallest_neighbor;
                    }
                    //now the max square width/ht with (r,c) at the corner is one more than smallest_neighbor.
                    //squares with ht 1 -> smallest_neighbor+1
                }
                else
                    t[r][c] = 0;
                ans += t[r][c];
            }
        }//precomputation finish
        return ans;
    }
}
