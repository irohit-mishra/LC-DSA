class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate the current area
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            // Update maxArea if the current area is greater
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer with the smaller height towards the other pointer
            if (height[left] < height[right]) {
                int currentLeftHeight = height[left];
                // Skip unnecessary calculations
                while (left < right && height[left] <= currentLeftHeight) {
                    left++;
                }
            } else {
                int currentRightHeight = height[right];
                // Skip unnecessary calculations
                while (left < right && height[right] <= currentRightHeight) {
                    right--;
                }
            }
        }
        
        return maxArea;
    }
}
