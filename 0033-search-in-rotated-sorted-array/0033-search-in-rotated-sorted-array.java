/*Imagine having an array [0, 1, 2, 4, 5, 6, 7] which is sorted in ascending order.

Now, if we rotate this array at index 3, it becomes [4, 5, 6, 7, 0, 1, 2]. Here, 4 is the first element and the original order continues after wrapping around.

If we're given this rotated array [4, 5, 6, 7, 0, 1, 2] and we need to find the position of 6:

The array was originally [0, 1, 2, 4, 5, 6, 7].
After rotation, it became [4, 5, 6, 7, 0, 1, 2].
In this rotated array, 6 is at index 2.*/

class Solution {
    public int search(int[] nums, int target) {
        int left=0, right= nums.length -1;

        while (left <= right){
            int mid = left +(right - left)/2;

            if (nums[mid] == target){
                return mid;
            }

            //determine which part is sorted
            if(nums[left] <= nums[mid]){
                //left part is sorted
                if (nums[left] <= target && target < nums[mid]){
                    right = mid -1;
                }else{
                    left= mid +1;
                }
            } else{
                //right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
        }
        return -1; //target not found
    }
}