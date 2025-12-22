class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // dp[i][j] = LCS length of first i chars of text1 and first j chars of text2
        int[][] dp = new int[n + 1][m + 1];

        // initialize dp with -1
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return lcs(text1, text2, n, m, dp);
    }

    private int lcs(String s1, String s2, int n, int m, int[][] dp) {
        // base case
        if (n == 0 || m == 0) {
            return 0;
        }

        // memoization check
        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // recursive cases
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + lcs(s1, s2, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(
                lcs(s1, s2, n - 1, m, dp),
                lcs(s1, s2, n, m - 1, dp)
            );
        }

        return dp[n][m];
    }
}
