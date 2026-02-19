class Solution {
    class Pair {
        int node;
        double prob;
        public Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double p = succProb[i];
            adj.get(u).add(new Pair(v, p));
            adj.get(v).add(new Pair(u, p));
        }

        // Step 2: Max-heap (store highest probability first)
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.add(new Pair(start, 1.0));

        double[] dist = new double[n];
        dist[start] = 1.0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int u = cur.node;
            double prob = cur.prob;

            if (u == end) return prob;

            if (prob < dist[u]) continue;

            for (Pair nb : adj.get(u)) {
                double newProb = prob * nb.prob;
                if (newProb > dist[nb.node]) {
                    dist[nb.node] = newProb;
                    pq.add(new Pair(nb.node, newProb));
                }
            }
        }

        return 0.0; 
    }
}