class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        int n = s.length();

        // Try every possible starting shift i
        for (int i = 0; i < n; i++) {
            boolean match = true;
            
            // Check if goal matches s starting at shift i
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    match = false;
                    break;
                }
            }
            
            if (match) return true;
        }
        
        return false;
    }
}