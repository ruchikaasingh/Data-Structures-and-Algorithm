import java.util.*;

class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxConsecutiveGap(hBars);
        int maxV = maxConsecutiveGap(vBars);

        int side = Math.min(maxH, maxV);
        return side * side;
    }

    // Compute maximum consecutive gap in sorted array
    private int maxConsecutiveGap(int[] bars) {
        Arrays.sort(bars);
        int maxGap = 1, currGap = 1;

        for (int i = 1; i < bars.length; i++) {
            if (bars[i] == bars[i - 1] + 1) {
                currGap++;
            } else {
                currGap = 1;
            }
            maxGap = Math.max(maxGap, currGap);
        }
        return maxGap + 1; // +1 because gap size = streak length + 1
    }
}