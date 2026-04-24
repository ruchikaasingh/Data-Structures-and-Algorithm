class Solution {
    public int maxDistance(int[][] grid) {
        int n= grid.length;

        Queue<int[]> q= new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1){
                    q.offer(new int[]{i,j});
                }
            }
        }

        if(q.isEmpty() || q.size()==n*n) return -1;

        int dr[]= {0, 0, -1, 1};
        int dc[]= {-1, 1, 0, 0};
        int distance=0;

        while(!q.isEmpty()){
            int size= q.size();
            boolean newater= false;

            for(int k=0; k<size; k++){
                int cur[]= q.poll();

                for(int i=0; i<4; i++){
                    int newr= dr[i]+ cur[0];
                    int newc= dc[i]+ cur[1];

                    if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc]==0){
                        grid[newr][newc]=1;
                        q.offer(new int[]{newr, newc});
                        newater= true;
                    }
                }
            }
            if(newater) distance++;
        }
        return distance;
    }
}