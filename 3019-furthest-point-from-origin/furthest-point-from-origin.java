class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l=0;
        int r=0;
        int dash=0;
        int n= moves.length();

        for(int i=0; i<n; i++){
            if(moves.charAt(i)=='L') l++;
            else if(moves.charAt(i)=='R') r++;
            else dash++;
        }
        int max= Math.max(l,r);
        if(max==l) return l + dash - r;
        return r + dash - l;
    }
}