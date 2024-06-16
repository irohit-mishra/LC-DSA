class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);

        //create the copy of the sorted array to use as a ref
        int[] sorted = nums.clone();
        int n = nums.length;

        int left = (n - 1)/ 2; //middle element for the left part
        int right = n - 1; //left element for the roght part

        //step 2; reconstruct the array in the wiggle form
        for(int i = 0; i<n; i++){
            if(i % 2 == 0){
                nums[i] = sorted[left--];
            } else{
                nums[i] = sorted[right--];
            }
        }
    }
}