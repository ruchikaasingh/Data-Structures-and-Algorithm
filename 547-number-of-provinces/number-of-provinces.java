class Solution {
    public int findCircleNum(int[][] edges) {
        int v = edges.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= v; i++) {   //create v+1 lists (index 0 unused)
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i != j && edges[i][j] == 1) {
                    adj.get(i + 1).add(j + 1);
                }
            }
        }

        boolean[] vis = new boolean[v + 1];  //1 based
        int disconnected = 0;

        for (int i = 1; i <= v; i++) {
            if (!vis[i]) {
                dfs(i, vis, adj);
                disconnected++;
            }
        }
        return disconnected;
    }

    private void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        for (int nb : adj.get(node)) {
            if (!vis[nb]) {
                dfs(nb, vis, adj);
            }
        }
    }
}