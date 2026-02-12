class Solution {
    public int numEnclaves(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        for(int i=0; i<m; i++){
            if(grid[i][0]==1)dfs(i,0,grid, m, n);
            if(grid[i][n-1]==1) dfs(i,n-1,grid, m, n);
        }
        for(int j=0; j<n; j++){
            if(grid[0][j]==1)dfs(0,j,grid, m, n);
            if(grid[m-1][j]==1) dfs(m-1,j,grid, m, n);
        }

        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }

public void dfs(int i, int j, int grid[][], int m, int n){
    if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0) return;
    grid[i][j]=0;

    for(int k=0; k<4; k++){
        int dr[]= {-1,1,0,0};
        int dc[]= {0,0,-1,1};

        int nr= i+dr[k];
        int nc= j+dc[k];

        dfs(nr, nc, grid, m, n);
    }

}
}