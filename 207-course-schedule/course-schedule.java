class Solution {
    public boolean canFinish(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        int indegree[]= new int[n];
        for(int edge[]: edges){
            indegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
       ArrayList<Integer> topo= new ArrayList<>();

        while(!q.isEmpty()){
            int node= q.poll();
            topo.add(node);

            for(int nb: adj.get(node)){
                indegree[nb]--;

                if(indegree[nb]==0){
                    q.add(nb);
                }  
            }
        }
        return topo.size() == n;
    }
}