class Solution {
    public boolean isSubsequence(String s, String t) {
        int n= s.length();
        int m= t.length();

        int dp[][]= new int [n+1][m+1];
        for(int row[]: dp) Arrays.fill(row, -1);

         int ans =lcs(s, t, n, m, dp);
         if(ans==n) return true;
         return false;

    }
    public int lcs(String s, String t, int i, int j, int dp[][]){
        if(i==0 || j==0) return 0;

        if(dp[i][j]!= -1) return dp[i][j];
        if (s.charAt(i-1)== t.charAt(j-1)) dp[i][j]= 1+ lcs(s, t, i-1, j-1, dp);
        else dp[i][j]= Math.max(lcs(s, t, i-1, j, dp), lcs(s, t, i, j-1, dp));

        return dp[i][j];
    }
}