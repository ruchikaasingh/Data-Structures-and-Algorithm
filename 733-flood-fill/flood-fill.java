class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) return image; // no change needed
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oldColor, int newColor) {
        // Out of bounds
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        // Different color → stop
        if (image[sr][sc] != oldColor) return;

        // Fill current cell
        image[sr][sc] = newColor;

        // Recurse in 4 directions
        dfs(image, sr - 1, sc, oldColor, newColor); // up
        dfs(image, sr + 1, sc, oldColor, newColor); // down
        dfs(image, sr, sc - 1, oldColor, newColor); // left
        dfs(image, sr, sc + 1, oldColor, newColor); // right
    }
}