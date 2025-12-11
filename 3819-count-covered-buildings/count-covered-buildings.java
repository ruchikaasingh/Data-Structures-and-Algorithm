class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] north = new int[n+1], south = new int[n+1];
        int[] west = new int[n+1], east = new int[n+1];
        
        // Initialize
        Arrays.fill(north, Integer.MAX_VALUE);
        Arrays.fill(west, Integer.MAX_VALUE);
        Arrays.fill(south, 0);
        Arrays.fill(east, 0);
        
        // Fill extremes
        for(int[] b : buildings) {
            int x = b[0], y = b[1];
            north[x] = Math.min(north[x], y);
            south[x] = Math.max(south[x], y);
            west[y] = Math.min(west[y], x);
            east[y] = Math.max(east[y], x);
        }
        
        // Count covered
        int ans = 0;
        for(int[] b : buildings) {
            int x = b[0], y = b[1];
            if(north[x] < y && y < south[x] && 
               west[y] < x && x < east[y])
                ans++;
        }
        return ans;
    }
}
