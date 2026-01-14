class Solution {
    public int minCostClimbingStairs(int[] arr) {
        int n= arr.length;
        if(n==1) return arr[0];
        if(n==2) return Math.min(arr[0], arr[1]);

        int dp[]= new int[n+1];
        dp[0]= arr[0];
        dp[1]= arr[1];

        for(int i=2; i<n; i++){
            dp[i]= arr[i]+ Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}