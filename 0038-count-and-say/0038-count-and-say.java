public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) return ""; // Base case

        StringBuilder result = new StringBuilder("1"); // Start with the initial term

        for (int i = 1; i < n; i++) {
            StringBuilder nextTerm = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char current = result.charAt(j);
                if (current == prev) {
                    count++;
                } else {
                    nextTerm.append(count).append(prev);
                    prev = current;
                    count = 1;
                }
            }

            nextTerm.append(count).append(prev); // Append the count and the last character of the sequence
            result = nextTerm; // Update result for the next iteration
        }

        return result.toString();
    }
}
