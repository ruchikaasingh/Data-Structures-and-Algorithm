class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int childIndex = 0;
        int cookieIndex = 0;
        
        while (childIndex < g.length && cookieIndex < s.length) {
            if (s[cookieIndex] >= g[childIndex]) {
                childIndex++; 
            }
            // Always move to the next cookie (either it was used or it was too small)
            cookieIndex++;
        }
        
        return childIndex;
    }
}