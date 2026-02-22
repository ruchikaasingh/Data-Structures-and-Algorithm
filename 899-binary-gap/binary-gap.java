class Solution {
    public int binaryGap(int n) {
        String sb = Integer.toBinaryString(n);

        int count = -1;  
        int max = 0;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                if (count != -1) {
                    max = Math.max(max, count + 1); 
                }
                count = 0; 
            } else if (count != -1) {
                count++; 
            }
        }
        return max;
    }
}