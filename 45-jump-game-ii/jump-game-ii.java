class Solution {
    int[] memo;

    public int jump(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        
        return solve(0, nums);
    }

    private int solve(int i, int[] nums) {
        int n = nums.length;
        
        // Base case: If we reached or passed the last index, 0 more jumps needed
        if (i >= n - 1) return 0;
        
        if (memo[i] != -1) return memo[i];
        
        int minJumps = 10001;
        
        // Try every possible jump from the current index i
        for (int k = 1; k <= nums[i]; k++) {
            int result = solve(i + k, nums);
            
            // If the jump eventually reaches the end
            if (result != 10001) {
                minJumps = Math.min(minJumps, 1 + result);
            }
        }
        
        return memo[i] = minJumps;
    }
}