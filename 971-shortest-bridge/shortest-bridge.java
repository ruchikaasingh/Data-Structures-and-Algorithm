class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        //find land
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, q, i, j, n);
                    found = true;
                    break;
                }
            }
        }

        int steps = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                        if (grid[nr][nc] == 1) return steps; // reached second land
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private void dfs(int[][] grid, boolean[][] visited, Queue<int[]> q, int r, int c, int n) {
        if (r < 0 || r >= n || c < 0 || c >= n || visited[r][c] || grid[r][c] == 0) return;
        visited[r][c] = true;
        q.add(new int[]{r, c});
        dfs(grid, visited, q, r + 1, c, n);
        dfs(grid, visited, q, r - 1, c, n);
        dfs(grid, visited, q, r, c + 1, n);
        dfs(grid, visited, q, r, c - 1, n);
    }
}