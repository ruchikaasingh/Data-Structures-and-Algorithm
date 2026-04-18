class Solution {
    static int m, n;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m= image.length;
        n= image[0].length;

        int oldcolor= image[sr][sc];
        if(oldcolor==color) return image;

        flow(image, sr, sc, color, oldcolor);
        return image;
    }

    public static void flow(int image[][], int r , int c, int nc, int oldcolor){
        if(r>=m || c>=n || r<0 || c<0 || image[r][c]!= oldcolor) return;

        image[r][c]= nc;
        
        flow(image, r+1, c, nc, oldcolor);
        flow(image, r-1, c, nc, oldcolor);
        flow(image, r, c-1, nc, oldcolor);
        flow(image, r, c+1, nc, oldcolor);
    }
}