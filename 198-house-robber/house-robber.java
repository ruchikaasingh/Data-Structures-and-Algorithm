class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Build table
        for (int i = 2; i < n; i++) {
            int inc = nums[i] + dp[i - 2];
            int exc = dp[i - 1];
            dp[i] = Math.max(inc, exc);
        }

        return dp[n - 1];
    }
}
