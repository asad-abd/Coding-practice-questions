class _74_search_a_2d_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //move left or down from the top right corner
        int R=matrix.length, C=matrix[0].length;
        int row=0, col=C-1;
        while(row<R && col>=0){
            if(matrix[row][col]==target) return true;
            else if(matrix[row][col]>target){
                //move to left. if not possible, return false
                if(col==0) return false;
                else
                    col--;
            }
            else{
                //move down
                if(row==R-1) return false;
                else
                    row++;
            }
        }
        return false;
    }
}
