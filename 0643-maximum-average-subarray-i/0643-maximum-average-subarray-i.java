class Solution {
    public double findMaxAverage(int[] nums, int k) {
        //sum of first 'k' elements
        double currentSum = 0;
        for (int i = 0; i < k; i++ ){
            currentSum += nums[i];
        }

        //initializing the max sum as the sum of the first subarray
        double maxSum = currentSum;

        //sliding window technique
        for (int i = k; i < nums.length; i++){
            currentSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }
         return maxSum / k;
    }
}