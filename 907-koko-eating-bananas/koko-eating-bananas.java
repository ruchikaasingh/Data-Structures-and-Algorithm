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
            int mid = low + (high - low) / 2; 
            if (lowerbound(mid, piles) <= h) {
                ans = mid;       // valid s
                high = mid - 1;  // try smaller speed
            } else {
                low = mid + 1;   // need faster speed
            }
        }
        return ans;
    }

    private int lowerbound(int speed, int[] piles) {
        long hours = 0;
        for (int pile : piles) {
            // ceiling division: (pile + speed - 1) / speed
            hours += (pile + speed - 1) / speed;
            if (hours > Integer.MAX_VALUE) { 
                // safeguard against overflow, though h is int
                return Integer.MAX_VALUE;
            }
        }
        return (int) hours;
    }
}