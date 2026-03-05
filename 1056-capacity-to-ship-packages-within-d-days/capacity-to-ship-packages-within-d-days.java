class Solution {
    public int shipWithinDays(int[] w, int days) {
        int max= Integer.MIN_VALUE;
        int sum=0;

        for(int elem: w){
            max= Math.max(max, elem);
            sum+= elem;
        }

        int low= max;
        int high= sum;
        int ans= -1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(lowerbound(mid, w)<= days){
                high= mid-1;
                ans= mid;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }

    public int lowerbound(int capacity, int w[]){
        int days=0;
        int c= capacity;

        for(int elem: w){
            if(c>= elem){
                c-= elem;
            }
            else{
                days++;
                c= capacity- elem;
            }
        }
        days++;
        return days;
    }
}