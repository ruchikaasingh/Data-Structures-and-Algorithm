public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = piles[0];
        for (int pile : piles) {
            if (pile > high) {
                high = pile;
            }
        }

        int low = 1;
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2; // valid  s
            if (canFinish(piles, h, mid)) {
                ans = mid;       // valid
                high = mid - 1;  // try smaller speed
            } else {
                low = mid + 1;   // need faster speed
            }
        }
        return ans;
    }

    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            // ceiling division: (pile + k - 1) / k
            hours += (pile + k - 1) / k;
            if (hours > h) return false; // early exit optimization
        }
        return hours <= h;
    }
}