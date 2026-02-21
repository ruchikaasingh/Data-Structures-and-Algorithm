class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][] grid;
    private int[][] memo;
    private int n, m;
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int countPaths(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        memo = new int[n][m];
        
        long total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total = (total + dfs(i, j)) % MOD;
            }
        }
        return (int) total;
    }
    
    private int dfs(int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        
        long count = 1; 
        for (int[] d : dirs) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (ni >= 0 && nj >= 0 && ni < n && nj < m && grid[ni][nj] > grid[i][j]) {
                count += dfs(ni, nj);
                if (count >= MOD) count -= MOD;
            }
        }
        memo[i][j] = (int) count;
        return memo[i][j];
    }
}