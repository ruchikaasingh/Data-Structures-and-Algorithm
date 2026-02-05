class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); // undirected graph
        }
        
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }
    
    private boolean dfs(int node, int dest, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        if (node == dest) return true;
        visited[node] = true;
        
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, dest, adj, visited)) return true;
            }
        }
        return false;
    }
}