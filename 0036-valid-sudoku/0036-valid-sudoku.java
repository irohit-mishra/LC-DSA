class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check each row
        for (int i = 0; i < 9; i++) {
            if (!isValidRow(board, i)) {
                return false;
            }
        }
        
        // Check each column
        for (int j = 0; j < 9; j++) {
            if (!isValidColumn(board, j)) {
                return false;
            }
        }
        
        // Check each 3x3 box
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!isValidBox(board, i, j)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean isValidRow(char[][] board, int row) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[row][i] != '.' && used[board[row][i] - '1']) {
                return false;
            }
            if (board[row][i] != '.') {
                used[board[row][i] - '1'] = true;
            }
        }
        return true;
    }
    
    private boolean isValidColumn(char[][] board, int col) {
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && used[board[i][col] - '1']) {
                return false;
            }
            if (board[i][col] != '.') {
                used[board[i][col] - '1'] = true;
            }
        }
        return true;
    }
    
    private boolean isValidBox(char[][] board, int startRow, int startCol) {
        boolean[] used = new boolean[9];
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] != '.' && used[board[i][j] - '1']) {
                    return false;
                }
                if (board[i][j] != '.') {
                    used[board[i][j] - '1'] = true;
                }
            }
        }
        return true;
    }
}
