class Solution {
    static int parent[], size[];
    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        parent= new int[n+1];
        size= new int [n+1];

        for(int i=1; i<=n; i++){
            parent[i]=i;
        }
        Arrays.fill(size, 1);

        int ans[]= new int [2];
        for(int edge[]: edges){
            if(!union(edge[0], edge[1])){
                ans[0]= edge[0];
                ans[1]= edge[1];
            }
        }
        return ans;
    }

    public int find(int x){
        if(parent[x]==x)return x;
        return parent[x]= find(parent[x]);
    }

    public boolean union(int u, int v){
        int pu= find(u);
        int pv= find(v);

        if(pu==pv) return false;
        if(size[pu]< size[pv]){
            parent[pu]= pv;
            size[pv]+= size[pu];
        }
        else{
            parent[pv]= pu;
            size[pu]+= size[pv];
        }
        return true;
    }
}