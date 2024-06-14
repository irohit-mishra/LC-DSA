public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s; // If there's only one row, the output is the input string itself
        
        StringBuilder[] rows = new StringBuilder[numRows]; // Create an array of StringBuilders to store characters in each row
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder(); // Initialize each StringBuilder
        }
        
        int currentRow = 0; // Current row index
        boolean goingDown = false; // Flag to indicate whether the direction of traversal is going down
        
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c); // Append the current character to the StringBuilder of the current row
            
            if (currentRow == 0 || currentRow == numRows - 1) { // If we are at the topmost or bottommost row
                goingDown = !goingDown; // Change the direction of traversal
            }
            
            currentRow += goingDown ? 1 : -1; // Increment or decrement the current row index based on the direction of traversal
        }
        
        StringBuilder result = new StringBuilder(); // StringBuilder to store the final result
        for (StringBuilder row : rows) {
            result.append(row); // Append each row's characters to the result StringBuilder
        }
        
        return result.toString(); // Convert the StringBuilder to a String and return
    }
}
