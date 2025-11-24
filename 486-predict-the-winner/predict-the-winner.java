class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n= nums.length;
        int t= func(0,n-1, nums);
        return (t>=0);
    }
    
    public int func(int start, int end , int[]arr){
        if(start==end) return arr[start];

        int left= arr[start]- func(start+1, end, arr);
        int right= arr[end]- func(start, end-1, arr);
        return Math.max(left,right);
        
    }
}