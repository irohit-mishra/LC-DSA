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

/* class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]) return nums.length-1;
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]>nums[mid-1]&&nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid]>nums[mid-1]&&nums[mid]<nums[mid+1]) low=mid;
            else high=mid;
        }
        return 0;
    }
}*/