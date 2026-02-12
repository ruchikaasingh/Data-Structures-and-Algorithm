class Solution {
    static int m, n;
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        boolean[][] vis = new boolean[m][n];

        // Traverse boundary rows
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, vis, board);
            if (board[i][n - 1] == 'O') dfs(i, n - 1, vis, board);
        }

        // Traverse boundary columns
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j, vis, board);
            if (board[m - 1][j] == 'O') dfs(m - 1, j, vis, board);
        }

        // Flip unvisited 'O' to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !vis[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int i, int j, boolean[][] vis, char[][] board) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O' || vis[i][j]) return;

        vis[i][j] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nr = i + dr[k];
            int nc = j + dc[k];
            dfs(nr, nc, vis, board);
        }
    }
}