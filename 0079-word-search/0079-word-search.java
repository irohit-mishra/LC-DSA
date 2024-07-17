class Solution {
    public boolean exist(char[][] board, String word) {
      int rows = board.length;
      int cols = board[0].length;

      boolean[][] visited = new boolean [rows][cols];

      //traverse each cell in the grid
      for(int row = 0; row < rows; row++){
        for(int col = 0; col < cols; col++){
            //if the word can be found starting fro the cell, return true 
            if(dfs(board, word, row, col, 0, visited)){
                return true;
            }
        }
      }  
      //if no path found for the word, return false
      return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index, boolean[][]visited){
        //if the entire word has been found
        if(index == word.length()){
            return true;
        }

        //check boundries and if the cell is alreday visited or if the character doesn't match
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || 
        board[row][col] != word.charAt(index)){
            return false;
        }

        //mark the cell as visited
        visited[row][col] = true;

        //explore all the four possibke direction (up, down, left, right)
        boolean found = dfs(board, word, row + 1, col, index + 1, visited) ||
                        dfs(board, word, row - 1, col, index + 1, visited) ||
                        dfs(board, word, row, col+ 1, index + 1, visited) ||
                        dfs(board, word, row, col - 1, index + 1,visited);

        //unmark the cell as visited(backtrack)
        visited[row][col] = false;

        return found;
    }
}