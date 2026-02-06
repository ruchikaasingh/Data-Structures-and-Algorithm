class Solution {
    static int m, n;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, boolean[][] vis, char[][] grid) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        dfs(i + 1, j, vis, grid);
        dfs(i - 1, j, vis, grid);
        dfs(i, j + 1, vis, grid);
        dfs(i, j - 1, vis, grid);
    }
}