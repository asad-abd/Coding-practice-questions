class Solution {
    public boolean validRowCol(char[][] b, int x, boolean row){
        boolean visited[] = new boolean[b.length + 1];
        if(row){
            for(int y = 0; y < b.length; y ++){
                if(b[x][y] == '.')
                    continue;
                if(visited[b[x][y] - '0'])
                    return false;
                else 
                    visited[b[x][y] - '0'] = true;
            }
        }
        else{
            for(int y = 0; y < b.length; y ++){
                if(b[y][x] == '.')
                    continue;
                if(visited[b[y][x] - '0'])
                    return false;
                else 
                    visited[b[y][x] - '0'] = true;
            }
        }
        return true;
    }
    public boolean validSquare(char[][] b, int x, int y){
        boolean visited[] = new boolean[b.length + 1];
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(b[x + i][y + j] == '.')
                    continue;
                if(visited[b[x + i][y + j] - '0'])
                    return false;
                else 
                    visited[b[x + i][y + j] - '0'] = true;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // 9 rows check
        // 9 column checks
        for(int i = 0; i < 9; i ++){
            if(!validRowCol(board, i, true))
                return false;
            if(!validRowCol(board, i, false))
                return false;
        }
        // 9 square checks of size 3x3 
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++)
                if(!validSquare(board, i * 3, j * 3))
                    return false;
        }
        return true;
    }
}