class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        // Since elements are from 1 to n, size n + 1 is perfect
        int[] freq = new int[n + 1]; 
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            // Process element from array A
            freq[A[i]]++;
            if (freq[A[i]] == 2) {
                commonCount++;
            }

            // Process element from array B
            freq[B[i]]++;
            if (freq[B[i]] == 2) {
                commonCount++;
            }

            // The common count up to index i
            ans[i] = commonCount;
        }

        return ans;
    }
}