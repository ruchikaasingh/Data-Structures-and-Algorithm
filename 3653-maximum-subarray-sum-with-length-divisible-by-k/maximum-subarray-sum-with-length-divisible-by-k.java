class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long ans = Long.MIN_VALUE;
        long prefixSum = 0;
        int n = nums.length;

        long[] minPrefix = new long[k];
        java.util.Arrays.fill(minPrefix, Long.MAX_VALUE / 2);

        minPrefix[(k - 1) % k] = 0;

        for (int i = 0; i < n; ++i) {
            prefixSum += nums[i]; 
            
            int requiredRemainder = i % k;
            
            ans = Math.max(ans, prefixSum - minPrefix[requiredRemainder]);
            
            minPrefix[requiredRemainder] = Math.min(minPrefix[requiredRemainder], prefixSum);
        }

        return ans;
    }
}