class Solution {
    // dfs: instead of sinking -> save the border connected regions of O (for orange - not 0)
    public void save(char[][] b, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i >= m || j >= n || b[i][j] == '#' || b[i][j] == 'X')
            return;
        // mark as safe
        b[i][j] = '#';
        // System.out.println("b[i][j]: " + b[i][j]);
        save(b, i + 1, j, m, n);
        save(b, i, j + 1, m, n);
        save(b, i - 1, j, m, n);
        save(b, i, j - 1, m, n);
        
        return;
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        // traverse the borders and save the areas connected with them by marking them as safe (as '#')

        for(int i = 0; i < m; i ++){
            // save the regions connected to the left border
            if(board[i][0] == 'O')
                save(board, i, 0, m, n);
            // save the regions connected to the right border
            if(board[i][n - 1] == 'O')
                save(board, i, n - 1, m, n);
        }
        for(int j = 0; j < n; j ++){
            // save the regions connected to the top border
            if(board[0][j] == 'O')
                save(board, 0, j, m, n);
            // save the regions connected to the bottom border 
            if(board[m - 1][j] == 'O')
                save(board, m - 1, j, m, n);
        }
        
        // assign all '#' as 'O' and 'O' -> X
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
        return;
    }
}