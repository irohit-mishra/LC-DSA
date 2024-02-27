public class RemoveDuplicate {
    // method signature
    public int removeDuplicates(int[] nums) {
        // check array length
        if (nums.length<=1) return nums.length;
        // loop though the array
        int i=1;
        for (int j=1; j<nums.length; j++){
            //removing duplicates
            // checking whether current element is = next element; if continue
            // if current is not equal next save element
            if(nums[j]>nums[i-1]){
                nums[i]=nums[j];
                i++;
            }
        }
        //retuen length
        return i;
    }
}

/*int j=0;
 * for (int i=0; i<nums.length; i++){
 * if (nums[j]!= nums[i]){
 * nums[++j] = nums[i];
 * }
 * return j++;
 * 
 */