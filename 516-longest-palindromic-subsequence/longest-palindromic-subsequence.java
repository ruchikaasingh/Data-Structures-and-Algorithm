class Solution {

    public int longestPalindromeSubseq(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();

        int n = s1.length();
        int m = s2.length();

        int[][] memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return lcsMemo(s1, s2, 0, 0, memo);
    }

    public int lcsMemo(String s1, String s2, int i, int j, int[][] memo) {
    
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + lcsMemo(s1, s2, i + 1, j + 1, memo);
        } 
        else {
            memo[i][j] = Math.max(
                lcsMemo(s1, s2, i + 1, j, memo),
                lcsMemo(s1, s2, i, j + 1, memo)
            );
        }

        return memo[i][j];
    }
}
