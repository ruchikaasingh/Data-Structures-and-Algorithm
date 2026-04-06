class Solution {
    public boolean judgeCircle(String moves) {
        int totalx=0;
        int totaly=0;
        for(int i=0; i<moves.length(); i++){
            if(moves.charAt(i)=='U') totaly++;
            else if(moves.charAt(i)=='D') totaly--;
            else if(moves.charAt(i)=='R') totalx++;
            else totalx--;
        }
        if (totalx==0 && totaly==0) return true;
        return false;
    }
}