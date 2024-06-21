class Solution {
    public int uniquePaths(int m, int n) {
        // Calculate the total number of steps required to reach the bottom-right corner
        int totalSteps = m + n - 2;
        
        // Calculate the number of steps in one direction (either right or down)
        int stepsInOneDirection = Math.min(m, n) - 1;
        
        // Initialize result to 1
        long result = 1;
        
        // Calculate binomial coefficient (totalSteps choose stepsInOneDirection)
        for (int i = 1; i <= stepsInOneDirection; i++) {
            // Use long to prevent overflow
            result = result * (totalSteps - stepsInOneDirection + i) / i;
        }
        
        return (int) result;
    }
}