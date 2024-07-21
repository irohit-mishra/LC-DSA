class Solution {
    private int[] original;
    private int[] array;
    private Random random;

    public Solution(int[] nums) {
        original = nums.clone();
        array = nums.clone();
        random = new Random();
    }
    
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        for (int i = array.length-1; i>0; i--){
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */