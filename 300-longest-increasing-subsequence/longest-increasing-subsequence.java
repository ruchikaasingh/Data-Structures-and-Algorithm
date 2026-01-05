class Solution {
    int dp[][];

    public int solve(int i, int prevIdx, int[] nums) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][prevIdx + 1] != -1)
            return dp[i][prevIdx + 1];
        int len = solve(i + 1, prevIdx, nums); //not take
        if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
            len = Math.max(len, 1 + solve(i + 1, i, nums)); //take
        }
        return dp[i][prevIdx + 1] = len;

        //likhnne ka ek dusra tarika
        // int not_pick = solve(i+1, prevIdx, nums);   //not take
        // int pick = 0;
        // if(prevIdx == -1 || nums[i] > nums[prevIdx]) {
        //      pick = 1+solve(i+1, i, nums);   //take
        // }
        // return  dp[i][prevIdx+1] =  Math.max(pick ,not_pick);
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp = new int[n + 1][n + 1];
        // for(int i=0 ; i<n ; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return solve(0, -1, nums);

        int next[] = new int[n + 1];
        int curr[] = new int[n + 1];

        //tabulation TC : O(n^2) , SC:O(n)*2
        // for (int i = n - 1; i >= 0; i--) {
        //     for (int prevIdx = i - 1; prevIdx >= -1; prevIdx--) {
        //         int len = next[prevIdx + 1]; //not take
        //         if (prevIdx == -1 || nums[i] > nums[prevIdx]) {
        //             len = Math.max(len, 1 + next[i + 1]); //take
        //         }
        //         curr[prevIdx + 1] = len;
        //     }
        //     next=curr;
        // }
        // return next[-1 + 1];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prevIdx = 0; prevIdx < i; prevIdx++) {
                if (nums[prevIdx] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prevIdx]);
                }
            }
            maxi = Math.max(dp[i], maxi);
        }

        return maxi;
    }
}

//memo;-
//Jab prevIdx = -1 hota hai (initial call me),
//Tum dp[i][-1] access kar rahe ho thats why instead of dp[i][prevIdx]
//write dp[i][prevIdx+1]

//tabu:-
//tabulation me convert krte wqt prevIdx ko prevIdx+1 krna pdega har jagah 