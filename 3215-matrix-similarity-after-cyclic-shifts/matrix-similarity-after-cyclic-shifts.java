class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] shifted = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (i % 2 == 0) {
                leftShift(mat[i], k, shifted[i]);
            } else {
                rightShift(mat[i], k, shifted[i]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != shifted[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //left shift a row by k, store result in target
    public static void leftShift(int[] row, int k, int[] target) {
        int n = row.length;
        k = k % n; // handle large k
        for (int i = 0; i < n; i++) {
            target[i] = row[(i + k) % n];
        }
    }

    //right shift a row by k, store result in target
    public static void rightShift(int[] row, int k, int[] target) {
        int n = row.length;
        k = k % n; // handle large k
        for (int i = 0; i < n; i++) {
            target[i] = row[(i - k + n) % n];
        }
    }
}