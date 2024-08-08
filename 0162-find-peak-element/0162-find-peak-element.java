class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + (right - left)/2;

            //if mid is peak
            boolean isPeak =(mid == 0 || nums[mid] > nums[mid - 1]) && 
            (mid == nums.length - 1  || nums[mid] > nums[mid + 1]);

            if(isPeak){
                return mid;
            }

            if (mid < nums.length - 1 && nums[mid] < nums[mid + 1]){
                left = mid +  1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }
}