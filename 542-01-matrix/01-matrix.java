class Solution {
    public class Pair {
        int r, c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;

        int level[][]= new int[m][n];
        for(int row[]: level) Arrays.fill(row, -1);

         Queue<Pair> q= new LinkedList<>(); //stores 0 coords

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j]==0){
                    level[i][j]=0;
                    q.add(new Pair(i,j));
                } 
                else{
                    level[i][j]= -1;
                }
            }
        }
        int dr[]= {-1,1,0,0};
        int dc[]= {0, 0, -1, 1};
        while(!q.isEmpty()){
            Pair cur= q.poll();
            int r= cur.r;
            int c= cur.c;

            for(int k=0; k<4; k++){
                int nr= r+ dr[k];
                int nc= c+ dc[k];

                if(nc>=0 && nc<n && nr>=0 && nr<m && level[nr][nc]==-1){
                    level[nr][nc]= level[r][c]+1;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        return level;
    }
}