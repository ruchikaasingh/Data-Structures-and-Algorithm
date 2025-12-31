class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: rob houses [0 ... n-2]
        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);
        int case1 = fxn(0, n - 2, nums, dp1);

        // Case 2: rob houses [1 ... n-1]
        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);
        int case2 = fxn(1, n - 1, nums, dp2);

        return Math.max(case1, case2);
    }

    private int fxn(int i, int end, int[] nums, int[] dp) {
        if (i > end) return 0;
        if (dp[i] != -1) return dp[i];

        int inc = nums[i] + fxn(i + 2, end, nums, dp);
        int exc = fxn(i + 1, end, nums, dp);

        dp[i] = Math.max(inc, exc);
        return dp[i];
    }
}
