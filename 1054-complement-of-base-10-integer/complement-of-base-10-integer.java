class Solution {
    public int bitwiseComplement(int n) {
        int len= Integer.toBinaryString(n).length();
        return n^((1<<len)-1);
    }
}