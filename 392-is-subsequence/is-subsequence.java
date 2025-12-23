class Solution {
    public boolean isSubsequence(String s, String t) {
        int left = 0;

        for (int right = 0; right < t.length() && left < s.length(); right++) {
            if (s.charAt(left) == t.charAt(right)) {
                left++;
            }
        }

        return left == s.length();
    }
}
