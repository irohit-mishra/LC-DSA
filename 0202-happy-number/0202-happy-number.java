class Solution {
    public boolean isHappy(int n) {
        // Set to store seen sums to detect cycles
        Set<Integer> seen = new HashSet<>();
        
        // Iterate until n becomes 1 (happy number) or enters a cycle
        while (n != 1) {
            // Calculate the sum of squares of digits
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            // If the sum is already seen, it enters a cycle
            if (seen.contains(sum)) {
                return false;
            }
            // Add the current sum to the set
            seen.add(sum);
            // Update n to the sum for the next iteration
            n = sum;
        }
        // If n becomes 1, it's a happy number
        return true;
    }
}