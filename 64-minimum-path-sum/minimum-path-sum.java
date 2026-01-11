class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m][n];
        for(int []arr:dp){
            Arrays.fill(arr,-1);
        }
        return solve(grid,m,n,0,0,dp);
    }
    public int solve(int [][]grid,int m,int n,int i,int j,int [][]dp){
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        //down
        int d=solve(grid,m,n,i+1,j,dp); 
        int r=solve(grid,m,n,i,j+1,dp); 
        return dp[i][j]=Math.min(d,r)+grid[i][j];
    }
}