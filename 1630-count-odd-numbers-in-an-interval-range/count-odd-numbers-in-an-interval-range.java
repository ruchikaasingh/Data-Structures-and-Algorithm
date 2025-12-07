class Solution {
    public int countOdds(int low, int high) {
        int countt = 0;
        if(low % 2 != 0 || high % 2 != 0){
            countt++;
        }

        int diff = (high - low)/2;

        return diff + countt;
    }
}