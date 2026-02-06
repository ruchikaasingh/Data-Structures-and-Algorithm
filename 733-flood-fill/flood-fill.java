class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int nc) {
        int oc = image[sr][sc];
        if (oc == nc) return image; //no change
        dfs(image, sr, sc, oc, nc);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int oc, int nc) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) return;
        //different color then stop
        if (image[sr][sc] != oc) return;

        image[sr][sc] = nc;

        //dfs in all dir
        dfs(image, sr - 1, sc, oc, nc); //up
        dfs(image, sr + 1, sc, oc, nc); //down
        dfs(image, sr, sc - 1, oc, nc); //left
        dfs(image, sr, sc + 1, oc, nc); //right
    }
}