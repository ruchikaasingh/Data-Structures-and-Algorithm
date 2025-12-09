class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int x : nums) totalSum += x;

        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        int n = nums.length;

        int[][] dp = new int[n][target + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return fxn(0, target, nums, dp);
    }

    private boolean fxn(int i, int target, int[] nums, int[][] dp) {
        if (target == 0) return true;
        if (i == nums.length || target < 0) return false;

        if (dp[i][target] != -1) {
            return dp[i][target] == 1;
        }

        boolean take = fxn(i + 1, target - nums[i], nums, dp);
        boolean skip = fxn(i + 1, target, nums, dp);

        boolean ans = take || skip;
        dp[i][target] = ans ? 1 : 0;
        return ans;
    }
}
