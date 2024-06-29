public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        // Loop through each bit of the binary representation
        while (n != 0) {
            // Increment count if the least significant bit is set
            count += n & 1;
            // Right shift the number to check the next bit
            n >>>= 1;
        }
        return count;
    }
}
