class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return fxn(0, 0, dp, m, n);
    }

    public int fxn(int i, int j, int[][] dp, int m, int n) {
        // Out of bounds
        if (i >= m || j >= n) return 0;
        // Destination reached
        if (i == m - 1 && j == n - 1) return 1;
        // Already computed
        if (dp[i][j] != -1) return dp[i][j];

        int down = fxn(i + 1, j, dp, m, n);
        int right = fxn(i, j + 1, dp, m, n);

        return dp[i][j] = down + right;
    }
}