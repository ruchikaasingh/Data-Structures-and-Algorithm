class Solution {
    class Pair {
        int x, y, count;
        public Pair(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.count - b.count);

        dist[0][0] = grid[0][0];
        pq.add(new Pair(0, 0, dist[0][0]));

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int r = cur.x, c = cur.y, count = cur.count;

            if (r == m - 1 && c == n - 1) return count;

            if (count > dist[r][c]) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int newCount = count + grid[nr][nc];
                    if (newCount < dist[nr][nc]) {
                        dist[nr][nc] = newCount;
                        pq.add(new Pair(nr, nc, newCount));
                    }
                }
            }
        }

        return dist[m - 1][n - 1];
    }
}