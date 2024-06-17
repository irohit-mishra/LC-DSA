class Solution {
    // Define the mapping of digits to letters
    private Map<Character, String> phoneMap = new HashMap<>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, digits, 0, new StringBuilder());
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, int index, StringBuilder current) {
        // Base case: if the current combination has reached the length of digits
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);

        // Iterate over each letter and append it to the current combination
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            // Recursively explore the next digit
            backtrack(combinations, digits, index + 1, current);
            // Backtrack by removing the last added letter
            current.deleteCharAt(current.length() - 1);
        }
    }
}