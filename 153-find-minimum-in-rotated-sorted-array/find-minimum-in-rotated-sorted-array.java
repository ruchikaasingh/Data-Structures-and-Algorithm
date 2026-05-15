class Solution {
    public int findMin(int[] nums) {
        int n= nums.length;
        int low=0;
        int high= n-1;

        int min= 5005;

        while(low<=high){
            int mid= low+(high-low)/2;

            if(nums[low]< nums[high]){
                if(nums[low]< nums[mid]){
                    high= mid-1;
                }
                else{
                    low= mid+1;
                }
            }
            else{
                if(nums[high]< nums[mid]){
                    low= mid+1;
                }
                else{
                    high= mid-1;
                }
            }
            min= Math.min(min, nums[mid]);
        }
        return min;
    }
}