class Solution {
    static int parent[], size[];
    static int component;
    
    public static int find(int x){
        if(parent[x]==x)return x;
        return parent[x]= find(parent[x]);
    }
    
    public static void union(int u, int v){
        int pu= find(u);
        int pv= find(v);
        
        if(pu==pv) return;
        if(size[pu]< size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }
        else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
        component--;
    }
    public int findCircleNum(int[][] isconnected) {
        int v= isconnected.length;
        parent= new int[v];
        size= new int [v];
        component= v;
        
        //initialize dsu
        for(int i=0; i<v; i++){
            size[i]=1;
            parent[i]=i;
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                if(i!=j && isconnected[i][j]==1){
                    union(i,j);
                }
            }
        }
        return component;

    }   
}