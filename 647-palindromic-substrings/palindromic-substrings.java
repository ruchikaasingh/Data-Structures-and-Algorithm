class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        // l = length of substring
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;

                if (i == j) {
                    dp[i][j] = true;
                } 
                else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } 
                else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
                }

                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}
