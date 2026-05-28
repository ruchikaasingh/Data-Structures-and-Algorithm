class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n= piles.length;

        int high= piles[0];
        for(int pile: piles){
            high= Math.max(high, pile);
        }

        int ans= high;
        int low=1;
        while(low<= high){
            int mid= low+(high-low)/2;

            if(canEat(mid, piles) <= h){
                ans= mid; //possible ans
                high= mid-1;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }

    public static int canEat(int mid, int piles[]){
        long hours= 0;

        for(int pile: piles){
            hours += pile/mid;
            if(pile % mid != 0){
                hours++;
            }

            if(hours> Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }

        return (int)hours;
    }
}