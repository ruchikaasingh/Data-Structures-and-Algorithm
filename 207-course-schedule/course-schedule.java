class Solution {
    public boolean canFinish(int v, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<v; i++){
            adj.add(new ArrayList<>());
        }

        int indegree[]= new int[v];
        for(int edge[]: edges){
            adj.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }

        ArrayList<Integer> topo= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        
        for(int i=0; i<v; i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int node= q.poll();
            topo.add(node);

            for(int nb: adj.get(node)){
                indegree[nb]--;
                if(indegree[nb]==0) q.add(nb);
            }
        }
        return topo.size()==v;
    }
}