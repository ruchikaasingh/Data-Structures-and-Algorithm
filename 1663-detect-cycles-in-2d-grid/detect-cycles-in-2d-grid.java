class Solution {
    static int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    static int n, m;

    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] visit = new boolean[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (!visit[i][j] && dfs(i, j, -1, -1, grid, visit))
                    return true;
        return false;
    }

    private static boolean dfs(int r, int c, int pr, int pc, char[][] grid, boolean[][]visit) {
        visit[r][c] = true;
        
        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr != pr || nc != pc)
                if (nr >= 0 && nr < n && nc >= 0 && nc < m)
                    if (grid[nr][nc] == grid[r][c])
                        if (visit[nr][nc] || dfs(nr, nc, r, c, grid, visit))
                            return true;
        }
        return false;
    }
}