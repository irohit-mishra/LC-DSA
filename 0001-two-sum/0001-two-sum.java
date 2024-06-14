class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the value and its index
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (target - current element)
            int complement = target - nums[i];
            
            // Check if the complement exists in the HashMap
            if (map.containsKey(complement)) {
                // Return the indices if the complement is found
                return new int[] { map.get(complement), i };
            }
            
            // Add the current element and its index to the HashMap
            map.put(nums[i], i);
        }
        
        // If no solution is found, throw an exception (as per the problem's constraints)
        throw new IllegalArgumentException("No two sum solution");
    }
}