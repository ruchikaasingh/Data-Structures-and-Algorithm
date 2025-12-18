class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        // 1) Compute original profit:
        long orig = 0;
        for (int i = 0; i < n; i++) {
            orig += (long) strategy[i] * prices[i];
        }

        // 2) Prefix sums for weightedStrategy and plain prices:
        long[] prefWeighted = new long[n + 1];
        long[] prefPrices = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefWeighted[i + 1] = prefWeighted[i] + (long) strategy[i] * prices[i];
            prefPrices[i + 1] = prefPrices[i] + prices[i];
        }

        long bestGain = Long.MIN_VALUE;
        int half = k / 2;

        // 3) Slide window of length k
        for (int i = 0; i + k <= n; i++) {
            int start = i, mid = i + half, end = i + k;

            // weighted original sum in window
            long origWindow = prefWeighted[end] - prefWeighted[start];

            // new window sum: first half holds (0),
            // second half sells => sum prices[ mid .. end-1 ]
            long newWindow = prefPrices[end] - prefPrices[mid];

            long gain = newWindow - origWindow;
            bestGain = Math.max(bestGain, gain);
        }

        // 4) If all windows reduce profit, we can skip modification
        bestGain = Math.max(bestGain, 0L);

        return orig + bestGain;
    }
}
