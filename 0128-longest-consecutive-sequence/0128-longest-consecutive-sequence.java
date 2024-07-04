class Solution {
    public int longestConsecutive(int[] nums) {
        // Handle the edge cases where the array is empty or has only one element
        if (nums.length == 0) { 
            return 0; 
        }
        if (nums.length == 1) { 
            return 1; 
        }

        // Sort the array
        Arrays.sort(nums);

        int max = 1; // Variable to store the maximum length of consecutive sequence found
        int count = 1; // Variable to store the current length of consecutive sequence

        // Iterate through the sorted array to find consecutive sequences
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                // Skip duplicates
                continue;
            }
            if (nums[i] + 1 == nums[i + 1]) {
                // If the current number and the next number are consecutive, increment the count
                count++;
            } else {
                // If they are not consecutive, update the maximum length if necessary
                max = Math.max(max, count);
                // Reset count for the new sequence
                count = 1;
            }
        }

        // Return the maximum of the last counted sequence and the previously stored maximum
        return Math.max(max, count);
    }
}
