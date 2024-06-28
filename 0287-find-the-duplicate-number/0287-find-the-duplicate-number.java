class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point of the two pointers
        int tortoise = nums[0];
        int hare = nums[0];
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase 2: Find the "entrance" to the cycle
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        // The "entrance" to the cycle is the repeated number
        return tortoise;
    }
}