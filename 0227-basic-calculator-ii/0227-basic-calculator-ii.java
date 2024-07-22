class Solution {
    public int calculate(String s) {
        // Initialize variables
        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;
        char operation = '+';
        
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            // If the current character is a digit, form the number
            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + (currentChar - '0');
            }
            
            // If the current character is an operator or we are at the end of the string
            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == s.length() - 1) {
                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = currentNumber;
                } else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -currentNumber;
                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;
                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }
                
                // Reset current number and update the operation
                currentNumber = 0;
                operation = currentChar;
            }
        }
        
        // Add the last number to the result
        result += lastNumber;
        
        return result;
    }
}
