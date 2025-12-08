//memoization
class Solution {
    public static int helper(int[][] arr,int i,int j,int[][] dp){
        int n=arr.length;
        if(j<0 || j>=n) return Integer.MAX_VALUE;
        if(i==n-1){
            return arr[i][j];
        }
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        int dleft=helper(arr,i+1,j-1,dp);
        int down=helper(arr,i+1,j,dp);
        int dright=helper(arr,i+1,j+1,dp);
        dp[i][j]=arr[i][j]+Math.min(dleft,Math.min(down,dright));
        return dp[i][j];
    }
    public int minFallingPathSum(int[][] arr) {
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        int minSum=Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            minSum=Math.min(minSum,helper(arr,0,j,dp));
        }
        return minSum;
    }
}