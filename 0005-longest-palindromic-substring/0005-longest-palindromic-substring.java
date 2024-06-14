class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        // Step 1: Preprocess the input string
        StringBuilder processedString = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            processedString.append(c).append("#");
        }

        // Step 2: Calculate palindrome radius
        int[] radius = new int[processedString.length()];
        int center = 0;
        int maxRight = 0;
        for (int i = 0; i < processedString.length(); i++) {
            int mirror = 2 * center - i;
            if (i < maxRight) {
                radius[i] = Math.min(maxRight - i, radius[mirror]);
            }

            // Try to expand palindrome centered at i
            while (i - radius[i] - 1 >= 0 && i + radius[i] + 1 < processedString.length()
                    && processedString.charAt(i - radius[i] - 1) == processedString.charAt(i + radius[i] + 1)) {
                radius[i]++;
            }

            // Update center and maxRight if palindrome centered at i expands beyond maxRight
            if (i + radius[i] > maxRight) {
                center = i;
                maxRight = i + radius[i];
            }
        }

        // Step 3: Find the longest palindrome substring
        int maxRadius = 0;
        int centerIndex = 0;
        for (int i = 0; i < radius.length; i++) {
            if (radius[i] > maxRadius) {
                maxRadius = radius[i];
                centerIndex = i;
            }
        }

        int startIndex = (centerIndex - maxRadius) / 2;
        int endIndex = startIndex + maxRadius - 1;
        return s.substring(startIndex, endIndex + 1);
    }
}
