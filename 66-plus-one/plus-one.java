class Solution {
    public int[] plusOne(int[] digits) {

        int n = digits.length;

        // start from last digit
        for (int i = n - 1; i >= 0; i--) {

            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0; // carry forward
        }

        // if we reach here, all digits were 9
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}
