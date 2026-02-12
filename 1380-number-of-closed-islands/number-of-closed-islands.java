class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        //ignore boundary 0s
        for (int i = 0; i < m; i++) {
            dfs(i, 0, grid, m, n);
            dfs(i, n - 1, grid, m, n);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, grid, m, n);
            dfs(m - 1, j, grid, m, n);
        }

       //disconnected components...counting 0
        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] grid, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 1) return;
        grid[i][j] = 1; // mark visited
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            dfs(i + dr[k], j + dc[k], grid, m, n);
        }
    }
}