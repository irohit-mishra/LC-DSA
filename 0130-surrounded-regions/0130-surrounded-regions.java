class Solution {
    public void solve(char[][] board) {
       if (board == null || board.length == 0) return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        // Mark boundary 'O's and their adjacent 'O's as safe
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
        }
        
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
        }
        
        // Mark remaining 'O's as 'X's, and revert the marked 'S's back to 'O's
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'S') board[i][j] = 'O';
            }
        }
    }
    
    // DFS to mark 'O's connected to boundary 'O's as safe
    private void dfs(char[][] board, int row, int col) {
        int rows = board.length;
        int cols = board[0].length;
        
        if (row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] != 'O') return;
        
        board[row][col] = 'S'; // Mark as safe
        
        // Explore neighboring cells
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1); 
    }
}