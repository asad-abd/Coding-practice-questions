class Solution {
    // idea is to try a number, check if the answer is 'eventually' possible with it, if not, back track
    
    // The solution only beats 5% java solns. try optimizing later
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    public boolean solve(char[][] board) {
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                if(board[i][j] == '.'){
                    // insert 1-9 in it and check if correct
                    for(char k = '1'; k <= '9'; k ++){
                        board[i][j] = k;
                        if(!isValidSudoku(board))
                           board[i][j] = '.';
                        else{
                            if(solve(board) == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                        
                    }
                    if(board[i][j] == '.')
                        return false;
                }
            }
        }
        return true;
    }

    // checker
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
/*
class Solution {
    // idea is to try a number, check if the answer is 'eventually' possible with it, if not, back track
    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i ++){
            for(int j = 0; j < 9; j ++){
                if(board[i][j] == '.'){
                    // insert 1-9 in it and check if correct
                    for(char k = '1'; k <= '9'; k ++){
                        // board[i][j] = k;
                        if(isValidSudoku(board, k)){
                            board[i][j] = k;
                            solveSudoku(board);
                        }    
                        else
                            board[i][j] = '.';
                    }
                }
            }
        }
    }

    // checker
    public boolean validRowCol(char[][] b, int x, boolean row, char c){
        boolean visited[] = new boolean[b.length + 1];
        if(row){
            for(int y = 0; y < b.length; y ++){
                if(b[x][y] == c)
                    return false;
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
                if(b[y][x] == c)
                    return false;
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
    public boolean validSquare(char[][] b, int x, int y, char c){
        boolean visited[] = new boolean[b.length + 1];
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(b[x + i][y + j] == c)
                    return false;
                if(b[x + i][y + j] == '.')
                    continue;
                else if(visited[b[x + i][y + j] - '0'])
                    return false;
                else 
                    visited[b[x + i][y + j] - '0'] = true;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board, char c) {
        // 9 rows check
        // 9 column checks
        for(int i = 0; i < 9; i ++){
            if(!validRowCol(board, i, true, c))
                return false;
            if(!validRowCol(board, i, false, c))
                return false;
        }
        // 9 square checks of size 3x3 
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++)
                if(!validSquare(board, i * 3, j * 3, c))
                    return false;
        }
        return true;
    }
} */