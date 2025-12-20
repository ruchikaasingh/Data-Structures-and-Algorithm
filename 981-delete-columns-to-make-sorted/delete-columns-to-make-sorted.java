class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        int count = 0;

        for (int j = 0; j < cols; j++) {        // column
            for (int i = 0; i < rows - 1; i++) { // row
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    count++;
                    break;  // no need to check further rows
                }
            }
        }
        return count;
    }
}
