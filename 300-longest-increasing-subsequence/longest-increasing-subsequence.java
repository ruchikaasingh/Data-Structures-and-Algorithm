class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Every element alone is an LIS of length 1
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (nums[i] > nums[prev]) {
                    dp[i] = Math.max(dp[i], dp[prev] + 1);
                }
            }
        }

        int ans = 0;
        for (int val : dp) ans = Math.max(ans, val);

        return ans;
    }
}
