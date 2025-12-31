class Solution {
    public int rob(int[] nums) {
        int n= nums.length;

        int dp[]= new int[n];
        Arrays.fill(dp, -1);

        return fxn(0, nums, dp);
    }

    public int fxn(int i, int nums[], int dp[]){
        if(i>=nums.length) return 0;
        if(dp[i]!= -1) return dp[i];

        int inc=0;
        inc = nums[i]+ fxn(i+2, nums, dp);

        int exc= fxn(i+1, nums, dp);

        return dp[i]= Math.max(inc, exc);
    }
}