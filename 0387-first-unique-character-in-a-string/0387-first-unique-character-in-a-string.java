class Solution {
    public int firstUniqChar(String s) {
        // Create a HashMap to store the frequency of each character
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        // Populate the frequency map
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Iterate through the string to find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i; // Return the index of the first non-repeating character
            }
        }
        
        // If no non-repeating character is found, return -1
        return -1;
    }
}