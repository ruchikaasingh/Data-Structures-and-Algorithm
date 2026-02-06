class Solution {
    static int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] vis = new boolean[m][n];
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    int area = dfs(i, j, grid, vis);
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] vis) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || vis[i][j]) {
            return 0;
        }

        vis[i][j] = true;
        int area = 1;

        area += dfs(i + 1, j, grid, vis); //down
        area += dfs(i - 1, j, grid, vis); //up
        area += dfs(i, j + 1, grid, vis); //right
        area += dfs(i, j - 1, grid, vis); //left

        return area;
    }
}