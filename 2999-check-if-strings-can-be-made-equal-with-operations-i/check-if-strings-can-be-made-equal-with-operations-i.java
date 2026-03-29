class Solution {
    public boolean canBeEqual(String s1, String s2) {
        // Check if the even indices can be made to match
        boolean evenMatch = 
            (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
            (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));
            
        // Check if the odd indices can be made to match
        boolean oddMatch = 
            (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
            (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));
            
        // Both groups must be able to match for the strings to be equal
        return evenMatch && oddMatch;
    }
}