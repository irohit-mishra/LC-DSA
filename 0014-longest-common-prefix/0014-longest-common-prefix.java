class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Check for empty input
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Sort the array of strings
        Arrays.sort(strs);
        
        // Compare the first and last strings
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        // Find the common prefix between the first and last strings
        int length = Math.min(first.length(), last.length());
        int i = 0;
        while (i < length && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        // Return the common prefix
        return first.substring(0, i);
    }
}
