class Solution {
    static class pair{
        int row;
        int col;
        pair(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    public static void bfs(int i,int j,int[][] grid){
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,j));
        grid[i][j]=2;
        while(!q.isEmpty()){
            pair front=q.remove();
            int row=front.row;
            int col=front.col;
            //left
            if(col-1>=0 && grid[row][col-1]==1){
                grid[row][col-1]=2;
                q.add(new pair(row,col-1));
            }
            //right
            if(col+1<grid[row].length && grid[row][col+1]==1){
                grid[row][col+1]=2;
                q.add(new pair(row,col+1));
            }
            //up
            if(row-1>=0 && grid[row-1][col]==1){
                grid[row-1][col]=2;
                q.add(new pair(row-1,col));
            }
            //down
            if(row+1<grid.length && grid[row+1][col]==1){
                grid[row+1][col]=2;
                q.add(new pair(row+1,col));
            }
        }

    }
    public int numEnclaves(int[][] grid) {
        for(int i=0;i<grid[0].length;i++){
            if(grid[0][i]==1){
                bfs(0,i,grid);
            }
            if(grid[grid.length-1][i]==1){
                bfs(grid.length-1,i,grid);
            }

        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][0]==1){
                bfs(i,0,grid);
            }
            if(grid[i][grid[i].length-1]==1){
                bfs(i,grid[i].length-1,grid);
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;

    }
}