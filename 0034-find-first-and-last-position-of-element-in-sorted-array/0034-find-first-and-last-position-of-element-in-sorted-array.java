class Solution {
    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        int index = -1;

        while (left <= right){
            int mid = left + (right - left) / 2;

            if (nums[mid] == target){
                index = mid;
                right = mid - 1; //move left to the frst occurence
            }else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }
        return index;
    }
    private int findLast (int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        int index = -1;

        while (left <= right){
            int mid=  left +(right - left)/2;

           
            if (nums [mid] == target){
                index = mid;
                left = mid +1; //move right to find the last occurance
            } else if(nums[mid] < target){
                left = mid +1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
