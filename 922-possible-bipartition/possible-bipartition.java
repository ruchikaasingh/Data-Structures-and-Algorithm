class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] d : dislikes) {
            graph.get(d[0]).add(d[1]);
            graph.get(d[1]).add(d[0]);
        }

        int[] colors = new int[n + 1];
        Arrays.fill(colors, -1);

        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, colors, graph)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, int color, int[] colors, List<List<Integer>> graph) {
        colors[node] = color;
        for (int nb : graph.get(node)) {
            if (colors[nb] == -1) {
                if (!dfs(nb, 1 - color, colors, graph)) return false;
            } else if (colors[nb] == colors[node]) {
                return false;
            }
        }
        return true;
    }
}