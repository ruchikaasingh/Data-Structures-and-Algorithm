class Solution {
    int m, n;

    public int numSpecial(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    if (dfs(i, j, mat)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public boolean dfs(int i, int j, int[][] mat) {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        for (int d = 0; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];

            while (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (mat[nr][nc] == 1 && !(nr == i && nc == j)) {
                    return false; 
                }
                nr += dr[d];
                nc += dc[d];
            }
        }
        return true;
    }
}