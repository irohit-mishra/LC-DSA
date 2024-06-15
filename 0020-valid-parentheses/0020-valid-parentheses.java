class Solution {
    public boolean isValid(String s) {
        // Stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();
        
        // Traverse each character in the string
        for (char c : s.toCharArray()) {
            // If the character is an opening bracket, push it onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If the character is a closing bracket
            else if (c == ')' || c == '}' || c == ']') {
                // If stack is empty, there is no corresponding opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                // Pop the top element from the stack
                char top = stack.pop();
                // Check if the popped element matches the corresponding opening bracket
                if ((c == ')' && top != '(') || 
                    (c == '}' && top != '{') || 
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // If the stack is not empty, there are unmatched opening brackets
        return stack.isEmpty();
    }
}
