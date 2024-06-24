class Solution {
    public void setZeroes(int[][] matrix) {
       if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
        return;
       }

       int m = matrix.length;
       int n = matrix[0].length;

       boolean firstRowZero = false;
       boolean firstColZero = false;

       // determine if first row needs to be zerod
       for (int j = 0; j < n; j++){
        if(matrix[0][j] == 0) {
            firstRowZero = true;
            break;
        }
       }

       //determine if first column needs to be zeroed
       for (int i = 0; i < m; i++){
        if (matrix[i][0] == 0){
            firstColZero = true;
            break;
        }
       }

       //use first row and col to mark zero rows and columns
       for(int i = 1; i < m; i++){
        for (int j=1; j < n; j++){
            if(matrix[i][j] == 0){
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
       }

       //zero out cells based on markers in first row and col
       for(int i = 1; i < m; i++){
        for(int j = 1; j < n; j++){
            if(matrix [i][0] == 0 || matrix[0][j] == 0){
                matrix[i][j] = 0;
            }
        }
       }

       //zero out first col if necessary
       if (firstRowZero){
        for (int j = 0; j < n; j++){
            matrix[0][j] = 0;
        }
       }

       //zero out the first column if necesssary
       if(firstColZero){
        for (int i = 0; i < m; i++){
            matrix[i][0]= 0;
        }
       }
    }
}