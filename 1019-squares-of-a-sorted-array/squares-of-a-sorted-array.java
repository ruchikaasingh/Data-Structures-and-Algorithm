class Solution {
    public int[] sortedSquares(int[] nums) {
        int n= nums.length;
        int ans[]= new int[n];

        for(int i=0; i<n; i++){
            nums[i]= nums[i]*nums[i];
        }

        int left=0;
        int right=n-1;
        int anspos= n-1;

        while(left<=right){
            if(nums[left]< nums[right]){
                ans[anspos--]= nums[right]; 
                right--;
            }
            else{
                ans[anspos--]= nums[left];
                left++;
            }
        }
        return ans;
    }
}