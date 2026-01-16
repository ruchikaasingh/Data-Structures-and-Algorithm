class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int [][] dp = new int[nums.length][2000];
        return helper(nums, target, 0, 0, dp);
    }

    public int helper(int[] nums, int target, int i, int sum, int [][] dp) {
        if (i == nums.length) {
            if(sum == target){
                return 1;
            }
            else{
                return 0;
            }
        }
        if (dp[i][sum + 1000] != 0){ 
            return dp[i][sum + 1000];
        }

        int plus = helper(nums, target, i + 1, sum + nums[i], dp);
        int minus = helper(nums, target, i + 1, sum - nums[i], dp);

        return dp[i][sum + 1000] = plus + minus;
    }
}