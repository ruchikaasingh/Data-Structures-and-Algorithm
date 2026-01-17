class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m + 1][n + 1];
        
        // Initialize with -1 meaning its not computed yet
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }
        
        return fxn(m, n, word1, word2, memo);
    }
    
    private int fxn(int i, int j, String word1, String word2, int[][] memo) {
        if (i == 0) return j; // need j inserts
        if (j == 0) return i; // need i deletes
        
        if (memo[i][j] != -1) return memo[i][j];
        
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            memo[i][j] = fxn(i - 1, j - 1, word1, word2, memo);
        } else {
            int insert = fxn(i, j - 1, word1, word2, memo);
            int delete = fxn(i - 1, j, word1, word2, memo);
            int replace = fxn(i - 1, j - 1, word1, word2, memo);
            memo[i][j] = 1 + Math.min(replace, Math.min(insert, delete));
        }
        
        return memo[i][j];
    }
}