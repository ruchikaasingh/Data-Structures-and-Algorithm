class Solution {
    public int findCenter(int[][] edges) {
        int v = edges.length + 1;
        int[] mat = new int[v + 1];

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < 2; j++) {
                int node = edges[i][j];
                mat[node]++;
            }
        }

        for (int i = 1; i < mat.length; i++) {
            if (mat[i] == v - 1) {
                return i;
            }
        }

        return -1;
    }
}
