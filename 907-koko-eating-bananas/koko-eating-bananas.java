class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = piles[0];
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] > high) {
                high = piles[i];
            }
        }

        int ans = high;
        int low = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEat(mid, piles, h)) {
                ans = mid; 
                high = mid - 1; 
            } else {
                low = mid + 1; 
            }
        }
        return ans;
    }

    public static boolean canEat(int mid, int[] piles, int h) {
        long hours = 0;

        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / mid;
            if (piles[i] % mid != 0) {
                hours++;
            }

            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}