public class _52_Spiral_Matrix_traversal {
    //edited some one else's code - redo later
    //We are letting the corner to be dealt by the left/right traversal
    //NOTICE THE last line of while loop. we change all 4 together!
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new LinkedList<>(); 
        if (matrix == null || matrix.length == 0) return res;
        int n = matrix.length, m = matrix[0].length;
        int up = 0,  down = n - 1;
        int left = 0, right = m - 1;
        while (res.size() < n * m) {
            for (int j = left; j <= right && res.size() < n * m; j++)
                res.add(matrix[up][j]);
            
            for (int i = up + 1; i <= down - 1 && res.size() < n * m; i++)//imp to note that we are letting the corner be dealt by the left/right traversal
                res.add(matrix[i][right]);
                     
            for (int j = right; j >= left && res.size() < n * m; j--)
                res.add(matrix[down][j]);
                        
            for (int i = down - 1; i >= up + 1 && res.size() < n * m; i--)//imp to note that we are letting the corner be dealt by the left/right traversal 
                res.add(matrix[i][left]);
                
            left++; right--; up++; down--; 
        }
        return res;
    }

    //my code (err) 
    /*
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        // [r, d, l , u] = [0, 1, 2, 3]
        int direction = 0;
        //initialize the limits
        int u = 0, r = matrix[0].length, d = matrix.length, l = 0;
        int i = 0, j = 0;
        int c = 0;
        while(c < matrix[0].length * matrix.length){
            if(direction == 0){
                for(i = u, j = l; j < r; j ++){
                    ans.add(matrix[i][j]);
                    c ++;
                }
                r --;
            }
            if(direction == 1){
                for(j = r - 1, i = u ; i < d; i ++){
                    ans.add(matrix[i][j]);
                    c ++;
                }
                d --;
            }
            if(direction == 2){
                for(i = d - 1, j = r - 1 ; j >= l; j --){
                    ans.add(matrix[i][j]);
                    c ++;
                }
                l ++;
            }
            if(direction == 3){
                for(j = l, i = d - 1 ; i >= u; i --){
                    ans.add(matrix[i][j]);
                    c ++;
                }
                u ++;
            }
            direction = (direction + 1) % 4;
        }
        return ans;
    }*/
}
