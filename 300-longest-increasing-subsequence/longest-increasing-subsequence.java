class Solution {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        
        int[][] dp = new int[n][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return fxn(0, -1, nums, dp);
    }

    public int fxn(int i, int previ, int[] nums, int[][] dp) {
        if (i == nums.length) return 0;

        if (dp[i][previ + 1] != -1)
            return dp[i][previ + 1];

        int exc = fxn(i + 1, previ, nums, dp);

        int inc = 0;
        if (previ == -1 || nums[i] > nums[previ]) {
            inc = 1 + fxn(i + 1, i, nums, dp);
        }

        return dp[i][previ + 1] = Math.max(inc, exc);
    }
}
