class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n= graph.length;
        List<List<Integer>> rev= new ArrayList<>();
        for(int i=0; i<n; i++){
            rev.add(new ArrayList<>());
        }

        int outdegree[]= new int[n];
        for(int i=0; i<n;  i++){
            outdegree[i]= graph[i].length;

            for(int nb: graph[i]){
                rev.get(nb).add(i);
            }
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0; i<n; i++){
            if(outdegree[i]==0){
                q.add(i);
            }
        }

        ArrayList<Integer> safe= new ArrayList<>();
        while(!q.isEmpty()){
            int cur= q.poll();
            safe.add(cur);

            for(int prev: rev.get(cur)){
                outdegree[prev]--;
                if(outdegree[prev]==0){
                    q.add(prev);
                }
            }
        }

        Collections.sort(safe);
        return safe;
    }
}