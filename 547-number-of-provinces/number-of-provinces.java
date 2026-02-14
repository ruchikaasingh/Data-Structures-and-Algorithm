class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited= new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,isConnected,visited);
            }
        }
        return count;
    }
    private void dfs(int city, int[][] isConnected,boolean[] visited){
        visited[city]=true;
        for(int n=0;n<isConnected.length;n++){
            if(isConnected[city][n]==1 && !visited[n]){
                dfs(n,isConnected,visited);
            }
        }
    }
}