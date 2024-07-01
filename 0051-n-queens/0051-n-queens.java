class Solution {
    public List<List<String>> solveNQueens(int n) { // takes an int n as input & return list of list of string
        List<List<String>> result = new ArrayList<>(); //  initializes an empty list named 'result' to store the solutions
        char[][] board = new char[n][n];//initializes a 2D character array named board of size n x n.
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        solveNQueensUtil(board, 0, result);//recursion
        return result;
    }

    private void solveNQueensUtil(char[][] board, int col, List<List<String>> result) {
        if (col == board.length) {
            result.add(constructSolution(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 'Q';
                solveNQueensUtil(board, col + 1, result);
                board[i][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col) {
        int i, j;
        // Check row on the left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }
        // Check upper diagonal on left side 
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check lower diagonal on left side 
        for (i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> constructSolution(char[][] board) {
        List<String> solution = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            solution.add(new String(board[i]));
        }
        return solution;
    }
}