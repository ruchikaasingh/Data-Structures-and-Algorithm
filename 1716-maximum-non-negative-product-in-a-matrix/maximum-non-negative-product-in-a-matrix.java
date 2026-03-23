class Solution {
    private static final long MOD = (long)1e9 + 7;

    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[][] maxDP = new long[n][m];
        long[][] minDP = new long[n][m];

        maxDP[0][0] = grid[0][0];
        minDP[0][0] = grid[0][0];

        // Fill first row
        for (int j = 1; j < m; j++) {
            maxDP[0][j] = maxDP[0][j-1] * grid[0][j];
            minDP[0][j] = maxDP[0][j];
        }

        // Fill first column
        for (int i = 1; i < n; i++) {
            maxDP[i][0] = maxDP[i-1][0] * grid[i][0];
            minDP[i][0] = maxDP[i][0];
        }

        // Dp
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long val = grid[i][j];
                long maxPrev = Math.max(maxDP[i-1][j], maxDP[i][j-1]);
                long minPrev = Math.min(minDP[i-1][j], minDP[i][j-1]);

                long cand1 = maxPrev * val;
                long cand2 = minPrev * val;

                maxDP[i][j] = Math.max(cand1, cand2);
                minDP[i][j] = Math.min(cand1, cand2);
            }
        }

        long result = maxDP[n-1][m-1];
        return result < 0 ? -1 : (int)(result % MOD);
    }
}