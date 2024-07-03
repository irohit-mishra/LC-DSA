class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to store groups of anagrams
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterate through each string in the array
        for (String str : strs) {
            // Convert the string to a character array, sort it, and convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // If the sorted string is already in the map, add the original string to its list
            // Otherwise, create a new list for the sorted string and add the original string to it
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortedStr, list);
            }
        }
        
        // Convert the values of the map to a list and return
        return new ArrayList<>(map.values());
    }
}