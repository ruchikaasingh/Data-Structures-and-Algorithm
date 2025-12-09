class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int x : nums) total += x;

        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            int val = nums[i - 1];
            for (int s = 1; s <= target; s++) {
                boolean notTake = dp[i - 1][s];
                boolean take = false;
                if (val <= s) {
                    take = dp[i - 1][s - val];
                }
                dp[i][s] = take || notTake;
            }
        }

        return dp[n][target];
    }
}
