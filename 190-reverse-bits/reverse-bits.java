public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result left to make space
            result <<= 1;
            // Extract the least significant bit of n
            result |= (n & 1);
            // Shift n right to process the next bit
            n >>>= 1;  // unsigned right shift
        }
        return result;
    }
}