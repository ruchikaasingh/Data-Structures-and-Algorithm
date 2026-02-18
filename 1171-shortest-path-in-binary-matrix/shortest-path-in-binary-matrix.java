class Solution {
    public class pair{
        int x, y, len;
        public pair(int x, int y, int len){
            this.x=x;
            this.y= y;
            this.len=len;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m= grid.length;
        int n= grid[0].length;

        PriorityQueue<pair> pq= new PriorityQueue<>((a,b)->a.len-b.len);
        int dist[][]= new int[n][n];
        int dr[]={-1,1,0,0,-1,-1,1,1};
        int dc[]={0,0,-1,1,-1,1,-1,1};

        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;

        for(int row[]: dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.add(new pair(0,0,1));
        dist[0][0]=1;

        while(!pq.isEmpty()){
            pair node= pq.poll();
            int r= node.x;
            int c= node.y;
            int d= node.len;

            if(d> dist[r][c]) continue;
            if(r==n-1 && c==n-1)return d;

            for(int k=0; k<8; k++){
                int nr= r+dr[k];
                int nc= c+ dc[k];

                if(nr>=0&& nr<n && nc>=0 && nc<n && grid[nr][nc]==0 ){
                    if(d+1<dist[nr][nc]){
                        dist[nr][nc]=d+1;
                        pq.add(new pair(nr, nc, dist[nr][nc]));
                    }
                }
            }
        }
        return -1;
    }
}