class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int[] colors = new int[v];
        Arrays.fill(colors, -1);

        for (int i = 0; i < v; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, colors, graph)) return false;
            }
        }
        return true;
    }

    public boolean dfs(int node, int color, int[] colors, int[][] graph) {
        colors[node] = color;
        for (int nb : graph[node]) {
            if (colors[nb] == -1) {
                if (!dfs(nb, 1 - color, colors, graph)) return false;
            } else if (colors[nb] == colors[node]) {
                return false;
            }
        }
        return true;
    }
}