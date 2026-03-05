class Solution {
    public int smallestDivisor(int[] nums, int thres) {
        int n= nums.length;
        int max= Integer.MIN_VALUE;
        for(int elem: nums){
            max= Math.max(max, elem);
        }

        int low= 1;
        int high= max;
        int ans= -1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(lowerbound(mid, nums) <=thres){
                high= mid-1;
                ans= mid;
            }
            else{
                low= mid+1;
            }
        }
        return ans;
    }
    public int lowerbound(int val, int nums[]){
        int sum=0;
        for(int elem: nums){
            sum+= (elem+ val -1)/val;
        }
        return sum;
    }
}