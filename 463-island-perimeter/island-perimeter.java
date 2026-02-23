class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid, vis); 
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int j, int[][] grid, boolean[][] vis) {
        int m = grid.length, n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) return 1;

        // Water.. contributes 1 edge
        if (grid[i][j] == 0) return 1;

        // Already visited land .. no contribution
        if (vis[i][j]) return 0;

        vis[i][j] = true;
        int perimeter = 0;

        int[] dr = {0, 0, -1, 1};
        int[] dc = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            perimeter += dfs(i + dr[k], j + dc[k], grid, vis);
        }

        return perimeter;
    }
}