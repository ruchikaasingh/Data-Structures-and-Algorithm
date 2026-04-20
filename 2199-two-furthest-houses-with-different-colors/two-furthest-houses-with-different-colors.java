class Solution {
    public int maxDistance(int[] colors) {
        int n= colors.length;
        if(colors[0]!=colors[n-1]){
            return n-1;
        }

        int maxdist= 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(colors[i]!=colors[j]){
                    maxdist= Math.max(maxdist, Math.abs(i-j));
                }
            }
        }
        return maxdist;
    }
}