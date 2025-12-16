class Solution {
    int m, n;
    int[][] memo;

    public int calculateMinimumHP(int[][] dungeon) {
        m = dungeon.length;
        n = dungeon[0].length;
        memo = new int[m][n];
        return fxn(0, 0, dungeon);
    }

    int fxn(int i, int j, int[][] dungeon) {
        // out of bounds
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        //bottom right cell
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        if (memo[i][j] != 0) return memo[i][j];

        int right = fxn(i, j + 1, dungeon);
        int down  = fxn(i + 1, j, dungeon);

        int need = Math.min(right, down) - dungeon[i][j];
        memo[i][j] = Math.max(1, need);

        return memo[i][j];
    }
}
