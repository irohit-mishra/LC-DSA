class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        int length = s.length();
        
        // DP table to check if a substring s[i:j+1] is a palindrome
        boolean[][] dp = new boolean[length][length];
        
        // Fill the DP table
        for (int end = 0; end < length; end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                    dp[start][end] = true;
                }
            }
        }
        
        backtrack(s, 0, currentPartition, result, dp);
        return result;
    }

    private void backtrack(String s, int start, List<String> currentPartition, List<List<String>> result, boolean[][] dp) {
        if (start == s.length()) {
            result.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) { // Check if substring s[start:end+1] is a palindrome
                currentPartition.add(s.substring(start, end + 1));
                backtrack(s, end + 1, currentPartition, result, dp);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }
}
