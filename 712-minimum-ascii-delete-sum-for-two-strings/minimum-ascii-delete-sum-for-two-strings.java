class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // dp[i][j] = maximum ASCII sum of common subsequence
        int[][] dp = new int[m + 1][n + 1];

       
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If characters match, add ASCII value
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    // take the best of skipping one character
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Total ASCII sum of both strings
        int total = getAsciiSum(s1) + getAsciiSum(s2);

        // Minimum delete sum = total - 2 * common subsequence sum
        return total - 2 * dp[m][n];
    }

    // Helper to compute ASCII sum of a string
    private int getAsciiSum(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += c;
        }
        return sum;
    }
}