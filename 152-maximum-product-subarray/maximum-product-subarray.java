class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        int maxProd = Integer.MIN_VALUE;
        int leftProduct = 1;
        int rightProduct = 1;

        for (int i = 0; i < n; i++) {
            // reset to 1 if the previous element was 0
            if (leftProduct == 0) leftProduct = 1;
            if (rightProduct == 0) rightProduct = 1;

            leftProduct *= nums[i];
            rightProduct *= nums[n - 1 - i];

            maxProd = Math.max(maxProd, Math.max(leftProduct, rightProduct));
        }

        return maxProd;
    }
}