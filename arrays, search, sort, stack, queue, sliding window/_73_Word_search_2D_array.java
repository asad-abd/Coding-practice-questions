class _73_Word_search_2D_array {
    // classic DFS
    public boolean exists(char[][] board, int m, int n, int x, int y, int i, char[] word){
        if(i == word.length)
            return true;
        
        if(x < 0 || x >= m || y < 0 || y >= n)
            return false;
        
        if(board[x][y] != word[i]){
//             System.out.println("board[x][y]" + board[x][y] + "   word[i]" + word[i]);
            return false;
        }
        char temp = board[x][y];
        board[x][y] = '0';
        boolean ans =  
            exists(board, m, n, x, y + 1, i + 1, word) || 
            exists(board, m, n, x, y - 1, i + 1, word) || 
            exists(board, m, n, x - 1, y, i + 1, word) || 
            exists(board, m, n, x + 1, y, i + 1, word);
        
        board[x][y] = temp;
        return ans;
    }
    public boolean exist(char[][] board, String Word) {
        int m = board.length, n = board[0].length;
        char [] word = Word.toCharArray();
        
        for(int row = 0; row < m; row ++){
            for(int col = 0; col < n; col ++){
                if(exists(board, m, n, row, col, 0, word))
                    return true;
            }
        }
        return false;
    }
    /*public boolean exist(char[][] board, int m, int n, int i, int[] j, char[] word){
        if(i == word.length)
            return true;
        
        if(board[j[0]][j[1]] == word[i]){
            boolean doesExist = false;
            for(int x = -1; x <= 1 && !doesExist; x += 2){
                for(int y = -1; y <= 1 && !doesExist; y += 2){
                    int newJ[] = {j[0] + x, j[1] + y};
                    if(newJ[0] >= 0 && newJ[0] < m && newJ[1] >= 0 && newJ[1] < n){
                        doesExist = doesExist || exist(board, m, n, i + 1, newJ, word);
                    }
                }
                
            }
            return doesExist;
        }
        return false;
    }
    public boolean exist(char[][] board, String Word) {
        int Row = board.length, Col = board[0].length;
        char [] word = Word.toCharArray();
        
        for(int row = 0; row < Row; row ++){
            for(int col = 0; col < Col; col ++){
                int j[] = {row, col};
                if(exist(board, Row, Col, 0, j, word))
                    return true;
            }
        }
        return false;
    }*/
}