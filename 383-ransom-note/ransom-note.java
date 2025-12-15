class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        // count letters in magazine
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // try to build ransomNote
        for (char ch : ransomNote.toCharArray()) {
            if (freq[ch - 'a'] == 0)
                return false;
            freq[ch - 'a']--;
        }

        return true;
    }
}
