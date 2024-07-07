class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a HashSet for fast look-up
        Set<String> wordSet = new HashSet<>(wordDict);
        
        // Set to store lengths of words in the dictionary
        Set<Integer> wordLengths = new HashSet<>();
        for (String word : wordDict) {
            wordLengths.add(word.length());
        }
        
        // DP array to store the segmentation status
        boolean[] dp = new boolean[s.length() + 1];
        
        // Base case: empty string
        dp[0] = true;
        
        // Fill the DP array
        for (int i = 1; i <= s.length(); i++) {
            for (int length : wordLengths) {
                if (i >= length && dp[i - length] && wordSet.contains(s.substring(i - length, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // The result is whether the entire string s can be segmented
        return dp[s.length()];
    }
}
