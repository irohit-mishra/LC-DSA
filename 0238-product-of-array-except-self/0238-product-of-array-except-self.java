class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        //initialize an array to store answer
        int[] answer = new int[n];

        int left=1;
        for(int i=0; i<n; i++){
            answer[i] = left;
            left *= nums[i];
        }

        int right=1;
        for(int i=n-1; i>=0; i--){
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }
}