import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Handle the edge case where the input array is null or empty
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Create a HashSet to store the numbers for O(1) average time complexity lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        // Iterate through the numbers in the array
        for (int num : nums) {
            // Check if the current number is the start of a sequence
            // A number is the start of a sequence if there is no (num - 1) in the set
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Increment the streak length while the next number in the sequence is found
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                // Update the longest streak found so far
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
