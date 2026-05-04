class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int ans[]= new int[n];

        // for(int i=0; i<n; i++){
        //     nums[i]= nums[i]*nums[i];
        // }

        int left=0;
        int right=n-1;
        int anspos= n-1;

        while(left<=right){
            int lval= nums[left]* nums[left];
            int rval= nums[right]* nums[right];

            if(lval< rval){
                ans[anspos--]= rval; 
                right--;
            }
            else{
                ans[anspos--]= lval;
                left++;
            }
        }
        return ans;
    }
}