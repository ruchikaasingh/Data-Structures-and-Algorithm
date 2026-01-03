class Solution {
    static final int INF = (int)1e9;

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = fxn(0, coins, amount, dp);
        return ans >= INF ? -1 : ans;
    }

    private int fxn(int i, int[] coins, int amount, int[][] dp) {
        if (amount == 0) return 0;
        if (i == coins.length) return INF;

        if (dp[i][amount] != -1) return dp[i][amount];

        int inc = INF;
        if (coins[i] <= amount) {
            inc = 1 + fxn(i, coins, amount - coins[i], dp);
        }

        int exc = fxn(i + 1, coins, amount, dp);

        return dp[i][amount] = Math.min(inc, exc);
    }
}
