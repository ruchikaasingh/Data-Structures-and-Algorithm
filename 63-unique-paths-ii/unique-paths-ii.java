class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        return fxn(0, 0, dp, m, n, grid);
    }

    public int fxn(int i, int j, int dp[][], int m, int n, int grid[][]) {
        if (i >= m || j >= n)
            return 0; //out of bounds
        if (grid[i][j] == 1)
            return 0; //obstacle encountered
        if (i == m - 1 && j == n - 1)
            return 1; //got one possibilty

        if (dp[i][j] != -1)
            return dp[i][j];

        int down = fxn(i + 1, j, dp, m, n, grid);
        int right = fxn(i, j + 1, dp, m, n, grid);

        return dp[i][j] = down + right;
    }
}